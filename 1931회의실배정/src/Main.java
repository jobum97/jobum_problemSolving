import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static String src="11\r\n"
			+ "1 4\r\n"
			+ "3 5\r\n"
			+ "0 6\r\n"
			+ "5 7\r\n"
			+ "3 8\r\n"
			+ "5 9\r\n"
			+ "6 10\r\n"
			+ "8 11\r\n"
			+ "12 12\r\n"
			+ "8 12\r\n"
			+ "12 14";
	
	static int n;
	static int result=0;
	
	public static void main(String arg[]) throws IOException {
		//input= new BufferedReader(new InputStreamReader(System.in));
		input= new BufferedReader(new StringReader(src));
		
		n=Integer.parseInt(input.readLine());
		StringTokenizer str;
		
		int[][] data=new int[n][2];
		
		for(int i=0;i<n;i++) {
			str=new StringTokenizer(input.readLine());
			data[i][0]=Integer.parseInt(str.nextToken());
			data[i][1]=Integer.parseInt(str.nextToken());
		}
		
		quickSort(data);
		
//		for(int i=0;i<n;i++) {
//			System.out.println(Arrays.toString(data[i]));
//		}
		
		
		find(data,0,0);
		System.out.print(result);
		
	}
	//회의실 선택하는 메소드, 끝나는 시간 오름차순으로 정렬되있기에 greedy하게 선택함
	public static void find(int[][] data,int start,int index) {
		if(index>=n) { //범위 벗어나면 리턴으로 끝내줌
			return;
		}
		if(start<=data[index][0]) { //회의 시작 시간이 허락만해주면 바로 집음 
			start=data[index][1];
			result++;
		}
		find(data,start,index+1);
	}
	
	//퀵소트 메소드 구현 부분
	public static void quickSort(int[][] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[][] arr, int low, int high) {
        if (low >= high) return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    public static int partition(int[][] arr, int low, int high) {
        int pivot = arr[(low + high) / 2][1];
        while (low <= high) {
            while (arr[low][1] < pivot) 
            	low++;
            while (arr[high][1] > pivot) 
            	high--;
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }
    //스왑부분을 조정함으로서 원하는대로 (회의 시간이 끝나는 시간이 빠른순, 같다면 시작시간이 더 빠른순) 정렬
    public static void swap(int[][] arr, int i, int j) {
        int tmp = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = tmp;
        
      //끝부분 숫자가 같은데 이미 시작부분 숫자도 정렬되있는 경우에는 스왑안함
        if(arr[i][1] == arr[j][1]&&arr[i][0] < arr[j][0]) { 
        }else {
        	tmp = arr[i][0];
            arr[i][0] = arr[j][0];
            arr[j][0] = tmp;
        }
        
    }
	
	
}
