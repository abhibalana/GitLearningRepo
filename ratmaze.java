package revisionques;

import java.util.Scanner;

public class RatMaze {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int a[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=sc.nextInt();
			}
			System.out.println();
		}
		 int solu[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				solu[i][j]=0;
			}
			System.out.println();
		}
		solve(a,n,solu);

	}
	 static void solve(int a[][],int n,int solu[][]) {
		
		if(!solvemazeuntil(a,n,0,0,solu)) {
			System.out.println("-1");
			return;
		}
		print(solu,n);
		return;
		
	}
	static void print(int solu[][],int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.println(solu[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	static boolean solvemazeuntil(int a[][],int n,int x,int y,int solu[][]) {
		if(x==n-1&&y==n-1&&a[x][y]>0) {
			solu[x][y]=1;
			return true;
		}
		int count=0;
		if(issafe(a,n,x,y)) {
			count=a[x][y];
			solu[x][y]=1;
			for(int i=0;i<count&&i<n;i++) {
				if(solvemazeuntil(a,n,x,y+i,solu)) return true;
				if(solvemazeuntil(a,n,x+i,y,solu)) return true;
			}
			solu[x][y]=0;
			return false;
			}
		return false;
	}
	static boolean issafe(int a[][],int n,int x,int y) {
		if(x>=0&&y>=0&&y<n&&x<n&&a[x][y]>=1) return true;
		return false;
	}

}
