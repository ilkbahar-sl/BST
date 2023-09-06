/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project2_trial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author sulei
 */
public class Project2_Trial {
        public static void main(String[] args) throws FileNotFoundException, IOException {
           
            Menu();

        }
        public static void Menu() throws FileNotFoundException, IOException{
            Scanner scan = new Scanner(System.in);
            BST myList = new BST() ;
            
            String fileName = "songs.txt";
            FileReader fileReader = new FileReader(fileName);
            String line;
            BufferedReader br = new BufferedReader(fileReader);
            System.out.println("SELECT THE ACTION YOU WANT TO DO:");
            System.out.println("\n1.Show the list with traverseIOrder " + "\n2.search with name " +"\n3.search with artist  " + "\n4.search with ID " + " \n5.Search with genre " + "\n6.search with range "  + "\n7.Delete the song with ıd "+ "\n8.Add a new the song "+ "\n9. Exit ");
            int choice = scan.nextInt();
            switch (choice) {
                    case 1:

                while ((line = br.readLine()) != null) {
                    String[] songInfoParts = line.split(";");

                if (songInfoParts.length == 5) {
                String songName = songInfoParts[0];
                String artist = songInfoParts[1];
                int ID = Integer.parseInt(songInfoParts[2]);
                String genre = songInfoParts[3];
                String year = songInfoParts[4];
                Song song = new Song(songName, artist, ID, genre, year);
                myList.insertWithId(song);
                        
                }
                }myList.traverseInOrder(myList.root);
                Menu();
                break;
                    
                    case 2:

                while ((line = br.readLine()) != null) {
                    String[] songInfoParts = line.split(";");

                if (songInfoParts.length == 5) {
                String songName = songInfoParts[0];
                String artist = songInfoParts[1];
                int ID = Integer.parseInt(songInfoParts[2]);
                String genre = songInfoParts[3];
                String year = songInfoParts[4];
                Song song = new Song(songName, artist, ID, genre, year);
                    myList.insertWithSongName(song);
                    
                }
                }myList.traverseInOrder(myList.root);
                    System.out.println("Listede aratmak istediğiniz ismi giriniz:");
                    scan.nextLine();
                    String songName_ = scan.nextLine();
                    System.out.println(myList.search(songName_));
                   
                   
                Menu();
                break;
                         
                    case 3:
                    while ((line = br.readLine()) != null) {
                    String[] songInfoParts = line.split(";");

                if (songInfoParts.length == 5) {
                String songName = songInfoParts[0];
                String artist = songInfoParts[1];
                int ID = Integer.parseInt(songInfoParts[2]);
                String genre = songInfoParts[3];
                String year = songInfoParts[4];
                Song song = new Song(songName, artist, ID, genre, year);
                    myList.insertWithSongArtist(song);
                }
                }myList.traverseInOrder(myList.root);
                        System.out.println("Listede aratmak istediğiniz artisti giriniz:");
                        scan.nextLine();
                        String artist_ = scan.nextLine();
                        System.out.println(myList.searchwithArtist(artist_));
                        Menu();
                    break;
                    
                    case 4:
                    while ((line = br.readLine()) != null) {
                    String[] songInfoParts = line.split(";");

                if (songInfoParts.length == 5) {
                String songName = songInfoParts[0];
                String artist = songInfoParts[1];
                int ID = Integer.parseInt(songInfoParts[2]);
                String genre = songInfoParts[3];
                String year = songInfoParts[4];
                Song song = new Song(songName, artist, ID, genre, year);
                    myList.insertWithId(song);
                   
                }
                }       myList.traverseInOrder(myList.root);
                        System.out.println("Aratmak istediğiniz ID yi giriniz:");
                        scan.nextLine();
                        int  ID_ =scan.nextInt();
                        System.out.println(myList.search(ID_));
                        
                   Menu();
                    break;
                    
                    case 5:
                    while ((line = br.readLine()) != null) {
                    String[] songInfoParts = line.split(";");

                if (songInfoParts.length == 5) {
                String songName = songInfoParts[0];
                String artist = songInfoParts[1];
                int ID = Integer.parseInt(songInfoParts[2]);
                String genre = songInfoParts[3];
                String year = songInfoParts[4];
                Song song = new Song(songName, artist, ID, genre, year);
                    myList.insertWithId(song);
                    
                }
                }       myList.traverseInOrder(myList.root);
                        System.out.println("Listemek istediğiniz genre yi  giriniz:");
                        scan.nextLine();
                        String genre_ = scan.nextLine();
                        myList.listSongsByGenre(genre_);
                    Menu();
                    break;
                    
                    case 6:
                    while ((line = br.readLine()) != null) {
                    String[] songInfoParts = line.split(";");

                if (songInfoParts.length == 5) {
                String songName = songInfoParts[0];
                String artist = songInfoParts[1];
                int ID = Integer.parseInt(songInfoParts[2]);
                String genre = songInfoParts[3];
                String year = songInfoParts[4];
                Song song = new Song(songName, artist, ID, genre, year);
                    myList.insertWithId(song);
                    
                }
                }       myList.traverseInOrder(myList.root);
                        System.out.println("Aratmak istediğiniz ID aralığını sırayla giriniz: " + "\nlowerBound" + "\nupperBound");
                        int lowerBound_ = scan.nextInt();
                        int upperBound_ = scan.nextInt();
                        myList.searchRange(lowerBound_, upperBound_);
                    Menu();
                    break;
                    case 7:
                        while ((line = br.readLine()) != null) {
                    String[] songInfoParts = line.split(";");

                if (songInfoParts.length == 5) {
                String songName = songInfoParts[0];
                String artist = songInfoParts[1];
                int ID = Integer.parseInt(songInfoParts[2]);
                String genre = songInfoParts[3];
                String year = songInfoParts[4];
                Song song = new Song(songName, artist, ID, genre, year);
                    myList.insertWithId(song);
                    
                }
                }       myList.traverseInOrder(myList.root);
                System.out.println("Enter the ID for deletion");
                        int ıd= scan.nextInt();
                        myList.deleteSong(ıd);
                        myList.traverseInOrder(myList.root);
                        BST.deleteSongFromTextFile(fileName, ıd);
                       
                        
                    Menu();
                    break;
                    case 8:
                    while ((line = br.readLine()) != null) {
                    String[] songInfoParts = line.split(";");

                if (songInfoParts.length == 5) {
                String songName = songInfoParts[0];
                String artist = songInfoParts[1];
                int ID = Integer.parseInt(songInfoParts[2]);
                String genre = songInfoParts[3];
                String year = songInfoParts[4];
                Song song = new Song(songName, artist, ID, genre, year);
                    myList.insertWithId(song);
                    
                }
                }       myList.traverseInOrder(myList.root);
                        scan.nextLine();
                        System.out.println("Enter songName:"  );
                        String newSongName=scan.nextLine();
                        
                        System.out.println("Enter artist:"  );
                        String newArtist=scan.nextLine();
                        
                        System.out.println("Enter ID:"  );
                        int newId=scan.nextInt();
                        scan.nextLine();
                        System.out.println("Enter genre:"  );
                        String newGenre=scan.nextLine();
                        
                        System.out.println("Enter year:"  );
                        String newYear=scan.nextLine();
                        
                        Song newSong = new Song(newSongName, newArtist, newId, newGenre, newYear);
                        myList.insertWithId(newSong);
                        myList.traverseInOrder(myList.root);
                        BST.AddFile(newSong);
                        
                        
                        
                    Menu();
                    break;
                    case 9:
                        break;
                        
                                
                            
                    
                    
                default:
                    throw new AssertionError();
            }
        }

}
            
            
    
       



            
    

