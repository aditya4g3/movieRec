import java.util.Scanner;
import java.util.Arrays;

public class Movie{
	
  public static boolean checkWord(String a, String b){
    Scanner tokenizer = new Scanner(a);
	String[] name = new String[10];
	String[] check = new String[10];
	int i=0, j=0, num=0;
	boolean status = false;
	while(tokenizer.hasNext()){
	   name[i]= tokenizer.next();
	   for(int tokenNum = 0; tokenNum<name[i].length(); tokenNum++){
		 if(!Character.isLetter((name[i].charAt(tokenNum))) && !Character.isDigit((name[i].charAt(tokenNum)))){
			 if(tokenNum+1 == name[i].length()){name[i] = name[i].substring(0,name[i].length()-1);}
			 else{name[i] = name[i].substring(0,tokenNum) + name[i].substring(tokenNum+1,name[i].length());}
		 }
       }		 
	     i++;
	}
	tokenizer = new Scanner(b);
	while(tokenizer.hasNext()){
	   check[j]= tokenizer.next();
	   for(int tokenNum = 0; tokenNum<check[j].length(); tokenNum++){
		 if(!Character.isLetter((check[j].charAt(tokenNum))) && !Character.isDigit((check[j].charAt(tokenNum)))){
			 if(tokenNum+1 == check[j].length()){check[j] = check[j].substring(0,check[j].length()-1);}
			 else{check[j] = check[j].substring(0,tokenNum) + check[j].substring(tokenNum+1,check[j].length());}
		 }
       }		 
	     j++;	  
	}
	for(int k=0; k<i; k++){
	  for(int l=0; l<j;l++){
		
        		
	    if(name[k].equalsIgnoreCase(check[l])){num++;}
	  }
	}
	if(((double)num)/j > 0.75){status = true;}
	return status;
  } 
  
  public static boolean checkClosest(String a, String b){
	a = a.toLowerCase();
	b = b.toLowerCase();
    char[] name = new char[40];
	char[] check = new char[40];
	int i=0, j=0, checkNum=0;
	boolean status = false;
	while(i<a.length()){
	 if(Character.isLetter(a.charAt(i))){
      name[i] = a.charAt(i);	
	  i++;
     }
	}	
    while(j<b.length()){
	 if(Character.isLetter(b.charAt(j))){
	  check[j] = b.charAt(j);
	  j++;
	 }
	}
	if(Math.abs(i-j) <= 1){
	for(int k=0; k<i; k++){
	  for(int l=0; l<j; l++){
		if(name[k] == check[l]){
		  checkNum++;
		  name[k] = '@';
		  check[l] = '#';
		}
	  }
	}
	}
	if((double)checkNum/i >= 0.8){status = true;}
	return status;
  }	
  
  
  private String name;
  private int year;
  private double rt;
  private double imdb;
  private int hours;
  private int mins;
  private boolean status;
  private String[] genre = new String[2];
  private String[] actor = new String[4];
  private String director;
  private static int currentMovieID = 0;
  private int movieID;
  
  public Movie (String n, int y, double r, double i, int hrs, int m, String g0, String g1, String a0, String a1, String a2, String a3, String dir){
    name = n;
	year = y;
	rt = r;
	imdb = i;
	hours = hrs;
	mins = m;
	status = false;
	genre[0] = g0;
	genre[1] = g1;
	actor[0] = a0;
	actor[1] = a1;
	actor[2] = a2;
	actor[3] = a3;
	director = dir;
	movieID = currentMovieID;
	currentMovieID++;
  }
  public String retName(){return name;}
  public int retYear(){return year;}
  public double retRT(){return rt;}
  public double retIMDB(){return imdb;}
  public String retGenre(int i){return genre[i];}
  public String retActor(int i){return actor[i];}
  public String retDirector(){return director;}
  public int retHours(){return hours;}
  public int retMins(){return mins;}
  public int retID(){return movieID;}
  
  public String retStatus(){
    String st;
	if(status)
	  st = "Downloaded";
	else
	  st = "Not Downloaded";
	return st;
  }
  
  public void changeName(String n){name = n;}
  public void changeYear(int y){year = y;}
  public void changeRT(double r){rt = r;}
  public void changeIMDB(double i){imdb = i;}
  public void changeStatus(){status = !status;}
  
  public void detailsOut(){
    System.out.println("\n\nName: " + name + "\nYear of Release: " + year + "\nRotten Tomatoes Score: " + rt + "\nIMDB Score: " + imdb);
    System.out.print("Running Time: " + hours + "h " + mins + "m" +"\nGenres: " + genre[0] + ", " + genre[1] + "\nCast: " + actor[0] + ", " + actor[1]);
    System.out.print(", " + actor[2] + ", " + actor[3]  + "\nDirector: " + director + "\nDownload Status: " + this.retStatus());
  }
  
   public void detailsOut(int i){
    System.out.println("\n\n" + i + ". Name: " + name + "\nYear of Release: " + year + "\nRotten Tomatoes Score: " + rt + "\nIMDB Score: " + imdb);
    System.out.print("Running Time: " + hours + "h " + mins + "m" +"\nGenres: " + genre[0] + ", " + genre[1] + "\nCast: " + actor[0] + ", " + actor[1]);
    System.out.print(", " + actor[2] + ", " + actor[3]  + "\nDirector: " + director + "\nDownload Status: " + this.retStatus());
  }
  
  public void searchMovie(int a, int b, double c, double d, String e, String f, String g){
	int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, i=0;
		
	if(year >= a && year <= b){c1 = 1;}
	
	if(c - rt < 0.01) {c2 = 1;}
	
	if(d - imdb <0.01){c3 = 1;}
	
	if(e.equalsIgnoreCase("n")){c4 = 1;}
	
	else if(genre[0].equalsIgnoreCase(e) || genre[1].equalsIgnoreCase(e)){c4 = 1;}
	
	if(f.equalsIgnoreCase("n")){c5 = 1;}
	
	else{
	  while (i <4){
	    if(checkWord(actor[i],f)){c5 = 1; break;}
		i++;
	  }
	}
	
	if(g.equalsIgnoreCase("n")){c6 = 1;}
	
	else if(checkWord(director,g)){c6 = 1;}
  
		
    if (c1 == 1 && c2 == 1 && c3 == 1 && c4 == 1 && c5 == 1 && c6 == 1){this.detailsOut();}
  }
  
  public boolean movieSearch(int a, int b, double c, double d, String e, String f, String g){
    int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, i=0;
	boolean check = false;	
	
	if(year >= a && year <= b){c1 = 1;}
	
	if(c - rt < 0.01) {c2 = 1;}
	
	if(d - imdb <0.01){c3 = 1;}
	
	if(e.equalsIgnoreCase("n")){c4 = 1;}
	
	else if(genre[0].equalsIgnoreCase(e) || genre[1].equalsIgnoreCase(e)){c4 = 1;}
	
	if(f.equalsIgnoreCase("n")){c5 = 1;}
	
	else{
	  while (i <4){
	    if(checkWord(actor[i],f)){c5 = 1; break;}
		i++;
	  }
	}
	
	if(g.equalsIgnoreCase("n")){c6 = 1;}
	
	else if(checkWord(director,g)){c6 = 1;}
	
    if (c1 == 1 && c2 == 1 && c3 == 1 && c4 == 1 && c5 == 1 && c6 == 1){check = true;}
	
	return check;
  }
  
  
  public void searchByName(String n){
	if (checkWord(name,n)){this.detailsOut();}
		
  }
  
  public void findByActor(String a){
	int i = 0;
	while(i<4){
      if(checkWord(actor[i],a)){this.detailsOut(); break;}
		i++;
	}
  }
  
  public void findByDirector(String d){
    if(checkWord(director,d)){this.detailsOut();}
  }
  
  
  public boolean actorCheck(String a){
    int i = 0; boolean check = false;
	while(i <4){
      if(checkWord(actor[i],a)){check = true; break;}
	  i++;
	}
	return check;
  }
  
  public void findByYear(int y){
    if(year == y){this.detailsOut();}
  }
  
  public void findByDecade(int d){
	  if(year >= d && year <= (9+d) && d%10 == 0){this.detailsOut();}
  }
  
  public void findByRunTime(int t){
	  if((hours*60 + mins) <= t ){this.detailsOut();}
  }
  
  public void findByGenre(String g){	   
    if(checkWord(genre[0],g)||checkWord(genre[1],g)){this.detailsOut();}
  }
   
  public int ratingsCompare(Movie other){
    double a = this.rt + this.imdb;
	double b = other.rt + other.imdb;
	if(a!=b){
		if(a > b){return -1;}
		else{return 1;}
	}	
	return alphaCompare(other);
  }
  
  public int alphaCompare(Movie other){
    return (int) this.name.compareTo(other.name);
  }
  
  public int latestCompare(Movie other){
    if(this.year != other.year){
      return other.year - this.year;
	}
	else{return alphaCompare(other);}
  }
  
  public int oldestCompare(Movie other){
    if(this.year != other.year){
      return this.year - other.year;
	}
	else{return alphaCompare(other);}
  }
  
  public int imdbCompare(Movie other){
	double a = this.imdb;
	double b = other.imdb;
	if(a!=b){
		if(a > b){return -1;}
		else{return 1;}
	}	
	return alphaCompare(other);
  }
  
  public int rtCompare(Movie other){
	double a = this.rt;
	double b = other.rt;
	if(a!=b){
		if(a > b){return -1;}
		else{return 1;}
	}	
	return alphaCompare(other);
  }
  
  
  public int compareTo(int opt, Movie other){
	int ret = 0;
    if(opt == 1)
		ret=alphaCompare(other);
	if(opt == 2)
		ret=imdbCompare(other);
	if(opt == 3)
		ret=rtCompare(other);
	if(opt == 4)
		ret=ratingsCompare(other);
	if(opt == 5)
		ret=latestCompare(other);
	if(opt == 6)
		ret=oldestCompare(other);
	
	return ret;
  }
	 
	
  
  public static String[] genreList(Movie[] M){
	String[] genre = new String[M.length*2];
	int i = 0, k=0;
	while(i < M.length){
		for(int j =0; j<2; j++){
		genre[k] = M[i].retGenre(j);
		k++;
		}
		i++;
    }
	Arrays.sort(genre);
	removeDuplicates(genre);
	String[] finalGenre = new String[3000]; int finalGenreNum = 0;
	for(int j = 0; j<genre.length; j++){
      if(!genre[j].equals("0")){
		 finalGenre[finalGenreNum] = genre[j];
		 finalGenreNum++;
	  }
	}			
	return (finalGenre);
  }
  
   public static void removeDuplicates(String[] s){
    for(int i = 0; i< s.length; i++){
	  for(int j = i+1; j< s.length; j++){
	    if(s[i].equals(s[j])){
		  s[j] = "0";
		}
	  }
	}       	
   } 
}

