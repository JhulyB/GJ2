package com.jhuly.wtcs;

/**
 * Created by sti01 on 22/08/16.
 */
public class _Default {

    protected String _mensagem;
    protected boolean _status;

    public _Default() {
        this._mensagem = "";
        this._status = true;
    }

    public String get_mensagem() {
        return _mensagem;
    }

    public void set_mensagem(String _mensagem) {
        this._mensagem = _mensagem;
    }

    public boolean is_status() {
        return _status;
    }

    public void set_status(boolean _status) {
        this._status = _status;
    }
}
