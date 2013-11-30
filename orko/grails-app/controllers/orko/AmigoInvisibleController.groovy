package orko



class AmigoInvisibleController {
	
	def amigoInvisibleService

    def index() {
		[amigoInvisible: new AmigoInvisibleCommand()] 
    }

    def generarAmigoInvisible(AmigoInvisibleCommand amigoInvisibleCommandInstance){
		Thread calcularResultado = new Thread(new Runnable() {
               public void run() {
            	   amigoInvisibleService.calcularAmigoInvisible(amigoInvisibleCommandInstance.amigosACalcular)
               }
          });
        calcularResultado.start();
		render(view:"resultado")
    }

}
