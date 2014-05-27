package file.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileController
{

	public void start()
	{

	}

	public FileController()
	{
		
		try
		{
			File file = new File("F:/Auth/UserNameAndLastNum.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			File folder = new File("C:/Users");
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++)
			{
				try
				{
					try
					{
						@SuppressWarnings("unused")
						int isAnError = Integer.parseInt(listOfFiles[i].getName().substring(0, 4));
					}
					catch (NumberFormatException e)
					{
						int lastNums = Integer.parseInt(listOfFiles[i].getName().substring(4));

						if (listOfFiles[i].isDirectory() && listOfFiles[i].getName().length() == 8 && lastNums > 1000 && !checkContents(readAllGameInformation(), listOfFiles[i].getName()))
						{

							output.write(listOfFiles[i].getName() + "\r\n" + listOfFiles[i].getName().substring(4) + "\r\n");

							System.out.println(listOfFiles[i].getName());
							System.out.println(listOfFiles[i].getName().substring(4));

						}

						
					}
				}
				catch (NumberFormatException e)
				{

				}
			}
			output.close();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}

	}
	private String readAllGameInformation()
	{
		String fileContents = "";
		String fileName = "F:/Auth/UserNameAndLastNum.txt";
		// String fileName = "C:/Auth/New Text Document.bat";
		File currentSaveFile = new File(fileName);
		Scanner fileReader;

		try
		{
			fileReader = new Scanner(currentSaveFile);
			while (fileReader.hasNext())
			{
				fileContents += fileReader.nextLine();
			}
			fileReader.close();
		}
		catch (FileNotFoundException fileDoesNotExist)
		{
			JOptionPane.showMessageDialog(null, fileDoesNotExist.getMessage());
		}
		return fileContents;

	}

	public boolean checkContents(String current, String checkText)
	{
		boolean isThere = false;

		if (current.contains(checkText))
		{
			isThere = true;
		}
		return isThere;
	}
}
