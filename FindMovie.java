import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FindMovie{
	
  public static void countMovieNum(int num){
    if (num == 0){System.out.println("\n\nSorry! No movies were found.");}
	
	else if (num == 1){System.out.println("\n\nShowing 1 movie.");}
	
	else{System.out.println("\n\nShowing " + num + " movies.");}
  }
  
  public static void main(String[] args) throws FileNotFoundException{
	  
    Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	Scanner sc3 = new Scanner(System.in);
	Scanner sc4 = new Scanner(System.in);
	Scanner sc5 = new Scanner(System.in);
	Scanner sc6 = new Scanner(System.in);
	Scanner sc7 = new Scanner(System.in);
	Scanner sc8 = new Scanner(System.in);
	Scanner sc9 = new Scanner(System.in);
	Scanner sc10 = new Scanner(System.in);
	Scanner sc11 = new Scanner(System.in);
	Scanner sc12 = new Scanner(System.in);
	Scanner sc13 = new Scanner(System.in);
	Scanner sc14 = new Scanner(System.in);
	Scanner sc15 = new Scanner(System.in);
	Scanner sc16 = new Scanner(System.in);
	Scanner sc17 = new Scanner(System.in);
	Scanner sc18 = new Scanner(System.in);
	int opt=0, i=0, num;
    boolean check;	
	File in = new File("MovieList1.txt");
	Scanner ReadLine = new Scanner(in);
	String line = "";
	String[] array = new String[13];
	Scanner scan;
	int inum;
	int jnum=0;
	Movie[] M = new Movie[510];
	while(ReadLine.hasNext()){		
	  line = ReadLine.nextLine();
	  scan = new Scanner(line);
	  scan.useDelimiter(",");
	  inum=0;
	  while(scan.hasNext()){
		array[inum] = scan.next();
		inum++;	
	  }
	  M[jnum] = new Movie(array[0],Integer.parseInt(array[1]),Double.parseDouble(array[2]),Double.parseDouble(array[3]),Integer.parseInt(array[4]),
	  Integer.parseInt(array[5]),array[6],array[7],array[8],array[9],array[10],array[11],array[12]);
	  jnum++;  
	}
	ReadLine.close();
    int arrayNum = jnum;
	while(opt!=9){
	  System.out.println("\n");
	  System.out.println("  __________________________________________________________");                     
	  System.out.println(" |1.Enter movie name to display details                     |");
	  System.out.println(" |2.Find Movie by year, genre, ratings, actor and director  |");
	  System.out.println(" |3.Display all movies of an actor/director                 |"); 
	  System.out.println(" |4.Display movies by year/decade                           |");
	  System.out.println(" |5.Display movies by genre                                 |");   
      System.out.println(" |6.Display all movies                                      |");	  
	  System.out.println(" |7.Search by running time                                  |");
	  System.out.println(" |8.Find similar movies.                                    |");
	  System.out.println(" |9.Quit                                                    |");
	  System.out.println(" |__________________________________________________________|"); 
	    
		System.out.print("\nEnter option: ");
	    opt = sc.nextInt();
		
	  if(opt == 1){
	   System.out.print("Enter the name of the movie: ");
	   String n = sc2.nextLine();
	   i=0; int nameNum=0;
	   while(i < arrayNum){
	     M[i].searchByName(n); 
		 if(Movie.checkWord(M[i].retName(),n)){nameNum++;}
		 i++;
	   }
	   countMovieNum(nameNum);
	  }
	  
	  else if (opt == 2){
	    num=0; i=0;
		int b=0;
		ArrayList <Movie> h = new ArrayList<Movie>();
		Sorter sort = new Sorter();
		System.out.println("\nFind movies by entering the following details");
	    System.out.print("Enter initial year (enter 0 to skip): ");
        int a = sc3.nextInt();
		while(a < 1930 && a!=0 || a > 2020){
		    System.out.print("Please enter a year between 1930 and 2020 (0 to skip): ");
			a = sc3.nextInt();
		}
		if(a == 0 ){a = 1930;}
		
		if(a != 2020){
		  System.out.print("Enter final year (enter 0 to skip): ");
          b = sc4.nextInt();
		  if(b != 0){
		   while(a > b && b!=0){
		  	System.out.print("Please enter a year after " + a + " (0 to skip): ");
		  	b = sc4.nextInt();
		  
		  	while(b > 2020){
		       System.out.print("This program can't predict future movies.\nPlease enter a year between " + a + " and 2020: ");
		       b = sc4.nextInt();
		    }
		   }
		  }
        }
		if(b == 0){b = 2020;}
		
	    System.out.print("Enter minimum Rotten Tomatoes rating (0 to 100) (enter 0 to skip): ");
	    double c = sc5.nextDouble();
		while(c < 0){
		  System.out.print("Why not watch something good while you're at it?\nTry entering a positive rating (0 to 100) (enter 0 to skip): ");
		  c = sc5.nextDouble();
		}
		while(c > 100){
		  System.out.print("Critics aren't that generous. Enter a minimum Rotten Tomatoes rating below 100: ");
          c = sc5.nextDouble();
        }		  
	    System.out.print("Enter minimum IMDB rating (0 to 9.2) (enter 0 to skip): ");
	    double d = sc6.nextDouble();
		while(d < 0){
		  System.out.print("You sure about this? Try entering a positive rating between 0 and 9.2: ");
		  d = sc6.nextDouble();
		}    
		while(d > 9.2){
		  System.out.print("The highest rating for a movie on IMDB is 9.2. Enter a rating between 0 and 9.2: ");
		  d = sc6.nextDouble();
		}
	    System.out.print("Enter genre (Thriller, Mystery, Crime, Noir, Sci-fi, Comedy etc) (enter n to skip): ");
	    String e = sc7.nextLine();
		System.out.print("Enter the name of an actor (enter n to skip): ");
		String f = sc8.nextLine();
		System.out.print("Enter the name of a director (enter n to skip): ");
		String g = sc9.nextLine();
		System.out.println("Order by\n1.Alphabetical \n2.IMDb score \n3.Rotten Tomatoes score \n4.IMDb + Rotten tomatoes score \n5.Latest \n6.Oldest");
		System.out.print("Enter option: ");
		int opt2 = sc6.nextInt();
		
		
		
	    while(i < arrayNum){
	      if(M[i].movieSearch(a,b,c,d,e,f,g)){num++; h.add(M[i]);}
		  i++;
		}
		 sort.insertionSort(opt2,h);	 
		 for(Movie temp: h){temp.detailsOut();}
		 countMovieNum(num);
	  }
	  
	  else if(opt == 3){
		i=0; num=0;
		Sorter sort = new Sorter();
		ArrayList<Movie> m = new ArrayList<Movie>();
	    System.out.print("Enter 'a' for actor or 'd' for director: ");
		char ch = sc10.next().charAt(0);
		while(ch != 'a' && ch != 'A' && ch != 'd' && ch != 'D'){ 
		    System.out.print("Invalid option! Enter 'a' for actor or 'd' for director: ");
			ch = sc10.next().charAt(0);
		}
		 if(ch == 'a'|| ch == 'A'){
		  System.out.print("Enter actor name: ");
		  String actName = sc11.nextLine();
	      while(i < arrayNum){
			if(M[i].actorCheck(actName)){num++;m.add(M[i]);}
			i++;
		  }
		 sort.insertionSort(1,m);	 
		 for(Movie temp: m){temp.detailsOut();}
		  countMovieNum(num);
		}
		else if (ch == 'd'|| ch == 'D'){
	      System.out.print("Enter director name: ");
		  String dirName = sc12.nextLine();
		  while(i < arrayNum){
			if(Movie.checkWord(M[i].retDirector(),dirName)){num++;m.add(M[i]);}
			i++;
		  }
		  sort.insertionSort(1,m);	 
		  for(Movie temp: m){temp.detailsOut();}
		  countMovieNum(num);
		}
	  }
	  
      else if(opt ==4){
	    i=0; num=0;		
		Sorter sort = new Sorter();
		ArrayList<Movie> m = new ArrayList<Movie>();
		System.out.print("Enter 'y' for year and 'd' for decade: ");
		char ch2 = sc14.next().charAt(0);
	    while(ch2 != 'y' && ch2 != 'Y' && ch2 != 'd' && ch2 != 'D'){ 
		  System.out.print("Invalid option! Enter 'y' for year and 'd' for decade: ");
		  ch2 = sc14.next().charAt(0);
		}
		if (ch2 == 'y' || ch2 == 'Y'){
	      System.out.print("Enter year: ");
		  int year = sc15.nextInt();
		  while (year < 1930 || year > 2020){
		    System.out.print("Please enter a year between 1930 and 2020: ");
			year = sc15.nextInt();
		  }
		  while(i < arrayNum){
			if(M[i].retYear() == year){num++;m.add(M[i]);}
			i++;
		  }
		  sort.insertionSort(1,m);	 
		  for(Movie temp: m){temp.detailsOut();}
		  countMovieNum(num);
		}
		else if (ch2 == 'd' || ch2 == 'D'){
		  System.out.print("Enter decade (1930-2010): ");
		  int decade = sc15.nextInt();
		  while(decade%10 !=0 || decade < 1930 || decade > 2020){
		    System.out.print("Please enter a valid input (1930- 2020): ");
			decade = sc15.nextInt();
		  }
		  while(i < arrayNum){
            if(M[i].retYear() >= decade && M[i].retYear() <= (9 + decade)){num++; m.add(M[i]);}
            i++;
		  }
		  sort.insertionSort(1,m);	 
		  for(Movie temp: m){temp.detailsOut();}
          countMovieNum(num);
        }
      }
	  
	  else if (opt == 5){	
        i=0; num=0;	  
		Sorter sort = new Sorter();
		ArrayList<Movie> m = new ArrayList<Movie>();
	    System.out.print("Enter genre: ");		
		String genre = sc17.nextLine();
        while(i < arrayNum){

          if(Movie.checkWord(M[i].retGenre(0),genre) || Movie.checkWord(M[i].retGenre(1),genre)){num++;m.add(M[i]);}
          i++;
	    }
		sort.insertionSort(1,m);	 
		for(Movie temp: m){temp.detailsOut();}
		countMovieNum(num);
	  }
	  
	  else if (opt == 6){
		i=0; 
		Sorter sort = new Sorter();
		ArrayList<Movie> m = new ArrayList<Movie>();
		System.out.println();
		while(i < arrayNum){
		  m.add(M[i]);
		  i++;
		}
		sort.insertionSort(1,m);	 
		for(i=0;i<m.size();i++){System.out.println(i+1+"."+m.get(i).retName());}
		System.out.print("\nEnter a movie number to display it's details: ");
		int movNum = sc18.nextInt();
		m.get(movNum-1).detailsOut();
	  }
      
      else if (opt == 7){
		 Sorter sort = new Sorter();
		 ArrayList<Movie> m = new ArrayList<Movie>();
		 System.out.print("Enter the maximum running time (in minutes): ");
         int runTime = sc.nextInt();	
		 i=0; num=0;
         while(i < arrayNum){
           if((M[i].retHours()*60 + M[i].retMins()) <= runTime){num++; m.add(M[i]);}
           i++; 
         }
		 sort.insertionSort(1,m);	 
		 for(Movie temp: m){temp.detailsOut();}
         countMovieNum(num);
	  }		 
           
      else if (opt == 8){
		 i=0;num=0;
         System.out.print("Enter the name of a movie: ");
         String movieName = sc18.next();
		 int[] movieNum = new int[30];
		 int movieNumCount = 0;
		 String g1,g2;
		 int ID;
		 int index = -1;
         while(i<arrayNum){
           if(Movie.checkWord(M[i].retName(),movieName)){
			 movieNum[movieNumCount] = i;
			 movieNumCount++;
			 num++;
		   }
		   i++;
		 }
		   if(num == 0){
			 countMovieNum(num);
		   }
		   else if(num == 1){ 
			 index = 0;
		   }
		   else{
			   i=0;
			   while(i<movieNumCount){
				 M[movieNum[i]].detailsOut(i+1);
				 i++;
			   }
			   System.out.print("\n\nWhich movie did you mean? Enter the option: ");
			   int movOpt = sc.nextInt();
			   while(movOpt > movieNumCount){
				 System.out.print("Enter a valid option: ");
				 movOpt = sc.nextInt();
			   }
			   index = movOpt-1;
		   }
		   if(index!=-1){
			 i=0;num=0;
		     System.out.println("Showing movies similar to " + M[movieNum[index]].retName()); 
		     g1 = M[movieNum[index]].retGenre(0);
			 g2 = M[movieNum[index]].retGenre(1);
			 ID = M[movieNum[index]].retID();
			 while(i<arrayNum){
			   if(M[i].retGenre(0).equals(g1) && M[i].retGenre(1).equals(g2) && M[i].retID()!=ID || M[i].retGenre(0).equals(g2) && M[i].retGenre(1).equals(g1) && M[i].retID()!=ID){
				   M[i].detailsOut();
				   num++;
			   }
			   i++;
			 }
			 countMovieNum(num);
          }
      } 		  
		  
	  else if(opt!=9){
	      System.out.println("Please enter a valid option (1-9). "); 
	  }
	}
  }
}
	
	
	
	
	
	