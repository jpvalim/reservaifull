package com.jpv.reservai.enums;

public enum StatusPagamento {
	
	PAGO (1),
	PENDENTE (2),
	FREE (3);
	
	private int code;
	
	private StatusPagamento (int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
		
	}
	
	public static StatusPagamento valueOf (int code) {
		for(StatusPagamento value : StatusPagamento.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}

}
