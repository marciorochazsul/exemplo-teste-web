package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;



public class Report implements MethodRule {
	
	private static final Logger LOGGER = Logger.getLogger(Report.class.getName());
	
   
	
  
	public Statement apply(final Statement statement,
			final FrameworkMethod frameworkMethod, final Object o) {

		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					statement.evaluate();	
					
					SimpleDateFormat d = new SimpleDateFormat("ddMMyyyy_HH_mm_ss");
					
					LOGGER.info(frameworkMethod.getName()+" - SUCESSO! ____________________    Data_hora:   "+ d.format(new Date()));
//					createDirectory(dir.getUrl_Logs());
//					File scrFile = ((TakesScreenshot) util.getDriver()).getScreenshotAs(OutputType.FILE);					
//					Files.copy(scrFile, new File(dir.getUrl_Logs()+"SUCESSO_"+ d.format(new Date()) + "_"+frameworkMethod.getName()+".png"));
//					util.getDriver().quit();
					
				} catch (Throwable t) {					

					captureScreenshot(frameworkMethod.getName());
					throw t;
				} finally {
				//	util.getDriver().quit();
					
					}
			}

			public void captureScreenshot(String fileName) {

				try {
					
					
					SimpleDateFormat d = new SimpleDateFormat("ddMMyyyy_HH_mm_ss");
					
					LOGGER.error(fileName+"  - FALHA! ____________________    Data_hora:   "+ d.format(new Date()));
//					createDirectory(dir.getUrl_Logs());
//					File scrFile = ((TakesScreenshot) util.getDriver()).getScreenshotAs(OutputType.FILE);					
//					Files.copy(scrFile, new File(dir.getUrl_Logs()+"FALHOU_"+ d.format(new Date()) + "_"+fileName+".png"));
					
				
				} catch (Exception e) {
                    LOGGER.error("Não capturou imagem -  " + e.getMessage(), e);
				} finally {					
				
				//	util.getDriver().quit();

				}
			}
		};
	}
	
	private void createDirectory(String path){
		File dir = new File(path);
		dir.mkdirs();
	}
}
