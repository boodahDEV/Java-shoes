package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class User implements UserInfoGlobalGit {
	 ProcessBuilder processBuilder = new ProcessBuilder();
	 String SO = System.getProperty("os.name");
	 
	@Override
	public String getUserName(String command) {
		// TODO Auto-generated method stub
		if(SO.indexOf("Windows") >= 0) {
			processBuilder.command("cmd.exe","/c",command);
			return ExecuteCommand(processBuilder);
		}else if(SO.indexOf("nix") >= 0 || SO.indexOf("nux") >= 0 || SO.indexOf("aix") > 0) {

			}else {
			
			}
		return null;
	}

	@Override
	public String getUserEmail(String command) {
		// TODO Auto-generated method stub
		if(SO.indexOf("Windows") >= 0) {
			processBuilder.command("cmd.exe","/c",command);
			return ExecuteCommand(processBuilder);
		}else if(SO.indexOf("nix") >= 0 || SO.indexOf("nux") >= 0 || SO.indexOf("aix") > 0) {

			}else {
			
			}
		return null;
	}

	@Override
	public String getBranch(String command) {
		// TODO Auto-generated method stub
		if(SO.indexOf("Windows") >= 0) {
			processBuilder.command("cmd.exe","/c",command);
			return ExecuteCommand(processBuilder);
		}else if(SO.indexOf("nix") >= 0 || SO.indexOf("nux") >= 0 || SO.indexOf("aix") > 0) {

			}else {
			
			}
		return null;
	}
	
	public String ExecuteCommand(ProcessBuilder processBuilder ) {
		try {
            Process process = processBuilder.start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder builder = new StringBuilder();
            String line = null;
            while ( (line = br.readLine()) != null) {
               builder.append(line);
               builder.append(System.getProperty("line.separator"));
            }
          
//            int exitCode = process.waitFor();
//            System.out.println("\nExited with error code : " + exitCode);
            
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

}
