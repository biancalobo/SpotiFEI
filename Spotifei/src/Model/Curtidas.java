/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author bianc
 */
public class Curtidas {
    private int usuarioId, musicaId;
    private boolean curtida;

    public Curtidas(int usuarioId, int musicaId, boolean curtida) {
        this.usuarioId = usuarioId;
        this.musicaId = musicaId;
        this.curtida = curtida;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getMusicaId() {
        return musicaId;
    }

    public void setMusicaId(int musicaId) {
        this.musicaId = musicaId;
    }

    public boolean isCurtida() {
        return curtida;
    }

    public void setCurtida(boolean curtida) {
        this.curtida = curtida;
    }

    @Override
    public String toString() {
        return "Curtidas{" + "usuarioId=" + usuarioId + ", musicaId=" +
                                    musicaId + ", curtida=" + curtida + '}';
    }
    
    
    
}
