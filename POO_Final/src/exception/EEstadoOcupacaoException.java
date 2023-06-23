package exception;

import java.io.Serializable;

public class EEstadoOcupacaoException extends Exception implements Serializable {

	private static final long serialVersionUID = 3928530748745792755L;
	
	public EEstadoOcupacaoException() {
        super();
    }

    public EEstadoOcupacaoException(String mensagem) {
        super(mensagem);
    }

    public EEstadoOcupacaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public EEstadoOcupacaoException(Throwable causa) {
        super(causa);
    }
}
