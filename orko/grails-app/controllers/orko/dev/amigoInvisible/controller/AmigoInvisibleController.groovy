package orko.dev.amigoInvisible.controller

import orko.dev.amigoInvisible.command.AmigoInvisibleCommand;



class AmigoInvisibleController {
	
	def amigoInvisibleService

    def index() {
		[amigoInvisible: new AmigoInvisibleCommand()] 
    }

    def generarAmigoInvisible(AmigoInvisibleCommand amigoInvisibleCommandInstance){
		if (!amigoInvisibleCommandInstance.hasErrors()){
			Thread calcularResultado = new Thread(new Runnable() {
	               public void run() {
	            	   amigoInvisibleService.calcularAmigoInvisible(amigoInvisibleCommandInstance.amigosACalcular)
	               }
	          });
	        calcularResultado.start();
			render(view:"resultado")
		}else{
			render(view:"index",model:[amigoInvisible: amigoInvisibleCommandInstance])
		}
    }

}
