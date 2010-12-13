
package com.dfkj.eoa.business;


public class BusinessFactory {

	/** Creates a new instance of BusinessFactory */
	private BusinessFactory() {
	}

	public static BusinessFactory newInstance() {
		return new BusinessFactory();
	}

	
	
        public IEoaDeptAct buildEoaDeptActImpl()
	{
		return new EoaDeptActImpl();
	}
   
    public IDepatManager buildDepatManagerImpl(){
	        return new DepatManagerImpl();
      }
   
  

}
