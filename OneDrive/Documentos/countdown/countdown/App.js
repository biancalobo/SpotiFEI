import React, { useState, useEffect } from "react";
import {View, Text, TextInput, TouchableOpacity, StyleSheet, Alert, Image, Vibration,} from "react-native";
import AsyncStorage from "@react-native-async-storage/async-storage";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { Audio } from "expo-av";
import * as Haptics from "expo-haptics";

const Stack = createNativeStackNavigator();

// Tela de Login
function LoginScreen({ navigation }) {
  const [usuario, setUsuario] = useState("");
  const [senha, setSenha] = useState("");

  const autenticar = async () => {
    const user = await AsyncStorage.getItem("usuario");
    const pass = await AsyncStorage.getItem("senha");

    if (usuario === user && senha === pass && usuario !== "") {
      navigation.replace("Home");
    } else {
      Alert.alert("Erro", "Usuário ou senha incorretos!");
    }
  };

  return (
    <View style={styles.container}>
      <Image style={styles.logo} source={require("./assets/logo2.png")} />
      <Text style={styles.texto}>Login</Text>

      <TextInput
        style={styles.input}
        placeholder="Usuário"
        value={usuario}
        onChangeText={setUsuario}
      />
      <TextInput
        style={styles.input}
        placeholder="Senha"
        secureTextEntry
        value={senha}
        onChangeText={setSenha}
      />

      <TouchableOpacity style={styles.botao} onPress={autenticar}>
        <Text style={styles.textoBotao}>Entrar</Text>
      </TouchableOpacity>

      <TouchableOpacity onPress={() => navigation.navigate("Cadastro")}>
        <Text style={{ color: "#ccc", marginTop: 12 }}>
          Ainda não tem conta? Cadastre-se
        </Text>
      </TouchableOpacity>
    </View>
  );
}

// Tela de Cadastro
function CadastroScreen({ navigation }) {
  const [usuario, setUsuario] = useState("");
  const [senha, setSenha] = useState("");

  const cadastrar = async () => {
    if (usuario && senha) {
      await AsyncStorage.setItem("usuario", usuario);
      await AsyncStorage.setItem("senha", senha);
      Alert.alert("Sucesso", "Usuário cadastrado!");
      navigation.replace("Login");
    } else {
      Alert.alert("Erro", "Preencha todos os campos!");
    }
  };

  return (
    <View style={styles.container}>
      <Image style={styles.logo} source={require("./assets/logo2.png")} />
      <Text style={styles.texto}>Cadastro</Text>

      <TextInput
        style={styles.input}
        placeholder="Usuário"
        value={usuario}
        onChangeText={setUsuario}
      />
      <TextInput
        style={styles.input}
        placeholder="Senha"
        secureTextEntry
        value={senha}
        onChangeText={setSenha}
      />

      <TouchableOpacity style={styles.botao} onPress={cadastrar}>
        <Text style={styles.textoBotao}>Cadastrar</Text>
      </TouchableOpacity>
    </View>
  );
}

// Tela inicial (Home)
function HomeScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <Text style={styles.texto}>Countdown</Text>
      <Image
        style={styles.imagem}
        source={require("./assets/countdown.png")}
      />

      <TouchableOpacity
        style={styles.botao}
        onPress={() => navigation.navigate("CountdownManual")}
      >
        <Text style={styles.textoBotao}>Escolher meu tempo</Text>
      </TouchableOpacity>

      <TouchableOpacity
        style={[styles.botao, { backgroundColor: "#555" }]}
        onPress={() => navigation.navigate("CountdownAleatorio")}
      >
        <Text style={styles.textoBotao}>Tempo aleatório</Text>
      </TouchableOpacity>
    </View>
  );
}

// Contagem
function CountdownScreen({ route, navigation }) {
  const { tempoInicial } = route.params;
  const [tempo, setTempo] = useState(tempoInicial);
  const [som, setSom] = useState(null);

  const tocarSom = async () => {
    const { sound } = await Audio.Sound.createAsync(
      require("./assets/countdown.mp3")
    );
    setSom(sound);
    await sound.playAsync();
  };

  useEffect(() => {
    let intervalo = null;

    if (tempo > 0) {
      intervalo = setInterval(() => setTempo((t) => t - 1), 1000);
    } else if (tempo === 0) {
      tocarSom();
      Vibration.vibrate([500, 500, 500], true);
      Haptics.notificationAsync(Haptics.NotificationFeedbackType.Error);
      navigation.replace("Final");
    }

    if (tempo === 60) {
      tocarSom();
    }

    return () => {
      clearInterval(intervalo);
      if (som) som.unloadAsync();
    };
  }, [tempo]);

  const formatarTempo = (t) => {
    const dias = Math.floor(t / 86400);
    const horas = Math.floor((t % 86400) / 3600);
    const minutos = Math.floor((t % 3600) / 60);
    const segundos = t % 60;
    return `${dias}d ${horas}h ${minutos}m ${segundos}s`;
  };

  return (
    <View style={styles.container}>
      <Text style={styles.texto}>Contagem Regressiva</Text>
      <Text style={styles.contador}>{formatarTempo(tempo)}</Text>

      <TouchableOpacity
        style={styles.botao}
        onPress={() => navigation.replace("Home")}
      >
        <Text style={styles.textoBotao}>Voltar</Text>
      </TouchableOpacity>
    </View>
  );
}

// ---------- CONTAGEM MANUAL ----------
function CountdownManual({ navigation }) {
  const [tempo, setTempo] = useState("");

  const iniciar = () => {
    const segundos = parseInt(tempo);
    if (!isNaN(segundos) && segundos > 0) {
      navigation.navigate("Countdown", { tempoInicial: segundos });
    } else {
      Alert.alert("Erro", "Insira um tempo válido em segundos!");
    }
  };

  return (
    <View style={styles.container}>
      <Image style={styles.logo} source={require("./assets/logo2.png")} />
      <Text style={styles.texto}>Escolha seu tempo</Text>

      <TextInput
        style={styles.input}
        placeholder="Tempo em segundos"
        keyboardType="numeric"
        value={tempo}
        onChangeText={setTempo}
      />

      <TouchableOpacity style={styles.botao} onPress={iniciar}>
        <Text style={styles.textoBotao}>Iniciar Contagem</Text>
      </TouchableOpacity>
    </View>
  );
}

// ---------- CONTAGEM ALEATÓRIA ----------
function CountdownAleatorio({ navigation }) {
  const gerarAleatorio = () => {
    const tempoAleatorio = Math.floor(Math.random() * 86400) + 60;
    navigation.navigate("Countdown", { tempoInicial: tempoAleatorio });
  };

  return (
    <View style={styles.container}>
      <Image style={styles.logo} source={require("./assets/logo2.png")} />
      <Text style={styles.texto}>Tempo Aleatório</Text>

      <TouchableOpacity style={styles.botao} onPress={gerarAleatorio}>
        <Text style={styles.textoBotao}>Gerar e Iniciar</Text>
      </TouchableOpacity>
    </View>
  );
}

// Fim da contagem
function FinalScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <Text style={[styles.texto, { color: "red" }]}>Seu tempo acabou!</Text>

      <TouchableOpacity
        style={styles.botao}
        onPress={() => {
          Vibration.cancel();
          navigation.replace("Home");
        }}
      >
        <Text style={styles.textoBotao}>Voltar ao Início</Text>
      </TouchableOpacity>
    </View>
  );
}

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{
          headerStyle: { backgroundColor: "black" },
          headerTintColor: "white",
          contentStyle: { backgroundColor: "white" },
        }}
      >
        <Stack.Screen name="Login" component={LoginScreen} />
        <Stack.Screen name="Cadastro" component={CadastroScreen} />
        <Stack.Screen name="Home" component={HomeScreen} />
        <Stack.Screen name="CountdownManual" component={CountdownManual} />
        <Stack.Screen name="CountdownAleatorio" component={CountdownAleatorio} />
        <Stack.Screen name="Countdown" component={CountdownScreen} />
        <Stack.Screen name="Final" component={FinalScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "black",
    alignItems: "center",
    justifyContent: "center",
    padding: 20,
  },
  texto: {
    color: "#fff",
    fontSize: 26,
    fontWeight: "bold",
    marginVertical: 20,
  },
  logo: {
    width: 280,
    height: 60,
    resizeMode: "contain",
    marginBottom: 20,
  },
  imagem: {
    width: 200,
    height: 200,
    marginBottom: 20,
  },
  input: {
    backgroundColor: "#fff",
    width: "80%",
    borderRadius: 8,
    padding: 10,
    fontSize: 18,
    marginVertical: 5,
    textAlign: "center",
  },
  botao: {
    backgroundColor: "#b33",
    paddingVertical: 12,
    paddingHorizontal: 25,
    borderRadius: 10,
    marginTop: 12,
  },
  textoBotao: {
    color: "#fff",
    fontWeight: "bold",
    fontSize: 16,
  },
  contador: {
    color: "#ff4444",
    fontSize: 32,
    fontWeight: "bold",
    marginVertical: 20,
  },
});
