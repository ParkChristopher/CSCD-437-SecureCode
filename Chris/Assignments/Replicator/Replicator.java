import java.io.*;

public class Replicator{
	
	public static char[] s = {
	'p',
	'u',
	'b',
	'l',
	'i',
	'c',
	' ',
	's',
	't',
	'a',
	't',
	'i',
	'c',
	' ',
	'v',
	'o',
	'i',
	'd',
	' ',
	'm',
	'a',
	'i',
	'n',
	'(',
	'S',
	't',
	'r',
	'i',
	'n',
	'g',
	'[',
	']',
	' ',
	'a',
	'r',
	'g',
	's',
	')',
	' ',
	't',
	'h',
	'r',
	'o',
	'w',
	's',
	' ',
	'I',
	'O',
	'E',
	'x',
	'c',
	'e',
	'p',
	't',
	'i',
	'o',
	'n',
	' ',
	'{',
	'\n',
	'\t',
	'P',
	'r',
	'i',
	't',
	'W',
	'r',
	'i',
	't',
	'e',
	'r',
	
	
	};
	
	public static void main(String[] args) throws IOException { 
		PrintWriter writer = new PrintWriter(new FileWriter("Replicator2.java"));
		
		writer.printf("import java.io.*;\n\n");
		writer.printf("public class Replicator{\n\n");
		writer.printf("\tpublic static char[]  s = {\n");
		
		for(int i = 0; i < s.length; i++){
			
			if(s[i] == '\n'){
				writer.printf("\t\'\\n\', \n");
			}
			
			else if(s[i] == '\t'){
				writer.printf("\t\'\\t\', \n");
			}
			else
				writer.printf("\t\'%c\', \n", s[i]);
		}
		writer.printf("\r\t};\n");
		
		for(int i = 0; i < s.length; i++){
			writer.print(s[i]);
		}
		writer.close();
	}

}