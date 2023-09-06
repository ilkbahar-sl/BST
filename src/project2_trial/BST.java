/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2_trial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

/**
 *
 * @author sulei
 */
public class BST{
    Song root;

    public BST() {
        root=null;
    }
    
    
    
    
    
    public void insertWithId(Song s){
    if(root==null){
    root=s;
    }else {
    Song tmp = root;
    Song parent =root;
    while(tmp!=null){
        parent = tmp;
        if(s.ID<tmp.ID){
        tmp = tmp.left;
        }else if(s.ID<tmp.ID){
        tmp = tmp.left;
        }else if(s.ID>tmp.ID){
        tmp= tmp.right;
        }
    }if(s.ID<parent.ID){
    parent.left = s;
    }else{
    parent.right=s;
            
    }
    }
    }
    public Song search(int ID){
        return searchRecursive(this.root,ID);
    }
    
    public Song searchRecursive(Song focus, int ID){
    if(focus ==null){return null;}
    if(focus.ID ==ID){return focus;}
    else if(ID<focus.ID){return searchRecursive(focus.left,ID);}
    else{return searchRecursive(focus.right, ID);}
    }
    
    /*public void insertWithSongName(Song s){
    if(root==null){
        root= s;
    }
    Song tmp = root;
    Song parent = root;
    while(tmp!=null){
    parent= tmp;
        if(s.songName.charAt(0)<tmp.songName.charAt(0)){
        tmp= tmp.left;
        }else if(s.songName.charAt(0)>tmp.songName.charAt(0)){
            tmp= tmp.right;
        }
        }
    if(s.songName.charAt(0)<parent.songName.charAt(0)){
        parent.left = s;
    }else{
        parent.right=s;
            
    }
    
    }*/
    
    public void insertWithSongName(Song s) {
            if (root == null) {
            root = s;
            return;
        }
            
        Song current = root;
        Song parent = null;

        while (true) {
            parent = current;

            if (s.songName.compareTo(current.songName) < 0) {
                current = current.left;
                if (current == null) {
                    parent.left = s;
                    return;
                }
            } else if (s.songName.compareTo(current.songName) > 0) {
                current = current.right;
                if (current == null) {
                    parent.right = s;
                    return;
                }
            }
            // Aynı veriyi tekrar eklemiyoruz, bu nedenle veri aynıysa hiçbir işlem yapmayız.
            else {
                return;
            }
        }
    }

    public Song search(String name){
        return searchRecursive(this.root,name);
    }
    
    public Song searchRecursive(Song focus, String name){
    if(focus ==null){return null;}
    if(focus.songName.equals(name)){return focus;}
    else if(name.compareTo(focus.songName)<0){return searchRecursive(focus.left,name);}
    else{return searchRecursive(focus.right, name);}
    }
    
    public void insertWithSongArtist(Song s) {
            if (root == null) {
            root = s;
            return;
        }
            
        Song current = root;
        Song parent = null;

        while (true) {
            parent = current;

            if (s.artist.compareTo(current.artist) < 0) {
                current = current.left;
                if (current == null) {
                    parent.left = s;
                    return;
                }
            } else if (s.artist.compareTo(current.artist) > 0) {
                current = current.right;
                if (current == null) {
                    parent.right = s;
                    return;
                }
            }
            // Aynı veriyi tekrar eklemiyoruz, bu nedenle veri aynıysa hiçbir işlem yapmayız.
            else {
                return;
            }
        }
    }
    
     public Song searchwithArtist(String artist){
        return searchWitArtistRecursive(this.root, artist);
    }
    
    public Song searchWitArtistRecursive(Song focus, String  artist){
    if(focus ==null){return null;}
    if(focus.artist.equals(artist)){return focus;}
    else if(artist.compareTo(focus.artist)<0){return searchWitArtistRecursive(focus.left,artist);}
    else{return searchWitArtistRecursive(focus.right, artist);}
    }
   
    
    public void listSongsByGenre(String genre) {
        inOrderTraversalwithGenre(root, genre);
    }

    private void inOrderTraversalwithGenre(Song node, String genre) {
        if (node != null) {
            inOrderTraversalwithGenre(node.left, genre);

            // Belirli bir türdeki şarkıları burada filtreleyebilirsiniz.
            if (genre.equalsIgnoreCase(node.genre)) {
                System.out.println(node.toString());
            }

            inOrderTraversalwithGenre(node.right, genre);
        }
    }
    
    public void searchRange(int lowerBound, int upperBound) {
        searchRangeRecursive(root, lowerBound, upperBound);
    }

    private void searchRangeRecursive(Song focus, int lowerBound, int upperBound) {
        if (focus == null) {
            return;
        }

        if (focus.ID >= lowerBound && focus.ID <= upperBound) {
            System.out.println(focus);
        }

        if (focus.ID > lowerBound) {
            searchRangeRecursive(focus.left, lowerBound, upperBound);
        }

        if (focus.ID < upperBound) {
            searchRangeRecursive(focus.right, lowerBound, upperBound);
        }
    }
public void deleteSong(int songID) {
    root = delete(root, songID);
}

    private Song delete(Song root, int songID) {
        if (root == null) {
            return root;
        }

        if (songID < root.ID) {
            root.left = delete(root.left, songID);
        } else if (songID > root.ID) {
            root.right = delete(root.right, songID);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.ID = minValue(root.right);
            root.right = delete(root.right, root.ID);
        }

        return root;
    }

    private int minValue(Song root) {
        int minValue = root.ID;
        while (root.left != null) {
            minValue = root.left.ID;
            root = root.left;
        }
        return minValue;
    }
    

    
        public void traverseInOrder(Song focus) { //left parent right
        if (focus.left != null) {
            traverseInOrder(focus.left);
        }
        System.out.println(focus);
        if (focus.right != null) {
            traverseInOrder(focus.right);
        }
        }
        
        
        public static void deleteSongFromTextFile(String fileName, int songID) {
        try {
            File inputFile = new File(fileName);
            File tempFile = new File("temp.txt");

        
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            
            String line;
            boolean songFound = false;

       while ((line = reader.readLine()) != null) {
            String[] songInfoParts = line.split(";");
            int ID = Integer.parseInt(songInfoParts[2]);

            if (ID != songID) {
                writer.write(line + System.getProperty("line.separator"));
            } else {
                songFound = true;
            }
        }

        writer.close();
        reader.close();

        if (songFound) {
                System.out.println("The song has been deleted from the text file.");
            } else {
                System.out.println("The song was not found in the text file.");
            }
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        try {
            
            BufferedReader dosya1Okuyucu = new BufferedReader(new FileReader("songs.txt"));
            BufferedReader dosya2Okuyucu = new BufferedReader(new FileReader("temp.txt"));

            StringBuilder dosya1Icerik = new StringBuilder();
            StringBuilder dosya2Icerik = new StringBuilder();
            String line;

            while ((line = dosya1Okuyucu.readLine()) != null) {
                dosya1Icerik.append(line).append("\n");
            }

            while ((line = dosya2Okuyucu.readLine()) != null) {
                dosya2Icerik.append(line).append("\n");
            }

            FileWriter dosya1Yazici = new FileWriter("songs.txt");
            FileWriter dosya2Yazici = new FileWriter("temp.txt");

            dosya1Yazici.write(dosya2Icerik.toString());
            dosya2Yazici.write(dosya1Icerik.toString());

            dosya1Okuyucu.close();
            dosya2Okuyucu.close();
            dosya1Yazici.close();
            dosya2Yazici.close();
            
            System.out.println("The contents of the files have been successfully changed.");
        } catch (IOException e) {
            System.err.println("Error: An error occurred during file operations.");
            e.printStackTrace();
        }
    }
        public static void AddFile(Song song) throws IOException {
        String fileName = "songs.txt"; 
        FileWriter Writer = new FileWriter(fileName, true);
        Writer.write("\n" +song.songName + ";" + song.artist + ";" + song.ID + ";" + song.genre + ";" + song.year);

        Writer.close();
    }

}
