package kakaoPayTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class codeTest1 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String[] args) throws IOException {
		Stack<Integer> st = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		sb.append(str);
		
		int ss = 0;
		String repeat = "";
		String text = "";
		String rplStr = "";
		int s = 0;
		
		for(int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '[') {
				st.add(i);
			}
		}
		while(!st.isEmpty()) {
			for(int i=0; i<str.length(); i++) {
				if (str.charAt(i) == ']') {
					ss = st.pop();
					int e = i;
					for(int j=ss-1; j>=0; j--) {
						if(Character.isDigit(str.charAt(j)) && j != 0) continue;
						else {
							if(j==0)
								s = j;
							else
								s = j+1;
							repeat = str.substring(s, ss);
							text = str.substring(ss+1, e);
							break;
						}
					}
					rplStr = decodeProduct(text, Integer.parseInt(repeat));
					
					sb.delete(s, e+1);
					sb.insert(s, rplStr);
					str = sb.toString();
					
					break;
				}
			}
			
		}
		
		bw.write(sb.toString());
		
		bw.close();
		br.close();
	}
	
	public static String decodeProduct(String text, int repeat) throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < repeat; i++) {
			sb.append(text);
		}
		
		return sb.toString();
	}
	
	
}
