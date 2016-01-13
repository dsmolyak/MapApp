package com.example.dsmolyak.mapapp;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.FileList;
import com.opencsv.CSVReader;

public class DriveConnect {
	public static void connect(InputStream fis) {

		try {
			String emailAddress = "goodymansthegoodman-864@tokyo-guild-114914.iam.gserviceaccount.com";
			
			String keyiD = "70bcd65a0234d166302332f163b119a96e41f247", iD = "";
			
			JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
			
			Collection<String> scopes = new ArrayList<String>();
			scopes.add("https://www.googleapis.com/auth/drive.file");
			scopes.add("https://www.googleapis.com/auth/drive.appdata");
			scopes.add("https://www.googleapis.com/auth/drive");
			
			HttpTransport httpTransport = AndroidHttp.newCompatibleTransport();

			InputStream in = fis;
			System.out.println(in);
			GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
			
			GoogleCredential credential = new GoogleCredential.Builder()
					.setTransport(httpTransport)
					.setJsonFactory(JSON_FACTORY)
					.setServiceAccountId(emailAddress)
					.setServiceAccountPrivateKeyFromP12File(
							new File("android.resource://raw/my_project_70bcd65a0234.p12"))
					.setServiceAccountScopes(scopes)
					.setClientSecrets(clientSecrets).build();
			
			Drive service = new Drive.Builder(httpTransport, JSON_FACTORY, null)
					.setApplicationName("My Project")
					.setHttpRequestInitializer(credential).build();
			
			FileList result = service.files().list().setMaxResults(10)
					.execute();
			
			List<com.google.api.services.drive.model.File> files = result
					.getItems();
			Log.println(1,"DEEZ NUTZ","LITMAN");
			if (files == null || files.size() == 0) {
				System.out.println("No files found.");
			} 
			
			else {
				for (com.google.api.services.drive.model.File file : files) {
					System.out.println(file.getTitle());
					
				if (file.getDownloadUrl() != null
							&& file.getDownloadUrl().length() > 0) {
						try {
							HttpResponse resp = service
									.getRequestFactory()
									.buildGetRequest(
											new GenericUrl(file
													.getDownloadUrl()))
									.execute();
							String is = resp.parseAsString();
							CSVReader reader = new CSVReader(new StringReader(
									is));
							String[] nextLine = reader.readNext();

							RoomHandler rh = new RoomHandler();
							HashMap<String, String[]> superHash = new HashMap<String, String[]>();
							while ((nextLine = reader.readNext()) != null) {
								HashMap<String, String> hash = new HashMap<String, String>();
								for (int x = 1; x < nextLine.length; x++) {
									String[] list = superHash.get(nextLine[x]);
									if(list!=null){
										list[x-1]=nextLine[0];
										superHash.put(nextLine[x], list);
									}
									else{
										String[] teachrs= new String[7];
										teachrs[x-1] = nextLine[0];
										superHash.put(nextLine[x], teachrs);
									}
									hash.put("" + x, nextLine[x]);
								}
								
								rh.addRoom(new Room(nextLine[0], hash));
							}
							rh.setSuperHash(superHash);
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
