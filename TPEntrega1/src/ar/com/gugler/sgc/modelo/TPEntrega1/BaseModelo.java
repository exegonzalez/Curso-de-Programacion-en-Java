package ar.com.gugler.sgc.modelo.TPEntrega1;

public abstract class BaseModelo {
	protected Long id;

	public BaseModelo(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
