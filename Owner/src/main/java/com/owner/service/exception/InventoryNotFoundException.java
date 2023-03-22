package com.owner.service.exception;

@SuppressWarnings({ "serial" })
public class InventoryNotFoundException extends Exception {
    
	
	public InventoryNotFoundException()  {
		super();
	}
		public InventoryNotFoundException(String message)  {
			super(message);
		}
			
			public InventoryNotFoundException(Throwable cause)  {
				super(cause);
		
	}
}
