import java.io.*;
import java.util.*;

public class Replicator{

	public static char[] s = {
	'\t',
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
	'\t',
	'R',
	'a',
	'n',
	'd',
	'o',
	'm',
	' ',
	'r',
	'a',
	'n',
	'd',
	' ',
	'=',
	' ',
	'n',
	'e',
	'w',
	' ',
	'R',
	'a',
	'n',
	'd',
	'o',
	'm',
	'(',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'S',
	't',
	'r',
	'i',
	'n',
	'g',
	' ',
	'f',
	'i',
	'l',
	'e',
	'n',
	'a',
	'm',
	'e',
	' ',
	'=',
	' ',
	'\"',
	'R',
	'e',
	'p',
	'l',
	'i',
	'c',
	'a',
	't',
	'o',
	'r',
	'\"',
	' ',
	'+',
	' ',
	'r',
	'a',
	'n',
	'd',
	'.',
	'n',
	'e',
	'x',
	't',
	'I',
	'n',
	't',
	'(',
	')',
	' ',
	'+',
	' ',
	'\"',
	'.',
	'j',
	'a',
	'v',
	'a',
	'\"',
	';',
	'\n',
	'\t',
	'\t',
	'P',
	'r',
	'i',
	'n',
	't',
	'W',
	'r',
	'i',
	't',
	'e',
	'r',
	' ',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	' ',
	'=',
	' ',
	'n',
	'e',
	'w',
	' ',
	'P',
	'r',
	'i',
	'n',
	't',
	'W',
	'r',
	'i',
	't',
	'e',
	'r',
	'(',
	'n',
	'e',
	'w',
	' ',
	'F',
	'i',
	'l',
	'e',
	'W',
	'r',
	'i',
	't',
	'e',
	'r',
	'(',
	'f',
	'i',
	'l',
	'e',
	'n',
	'a',
	'm',
	'e',
	')',
	')',
	';',
	'\n',
	'\n',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'i',
	'm',
	'p',
	'o',
	'r',
	't',
	' ',
	'j',
	'a',
	'v',
	'a',
	'.',
	'i',
	'o',
	'.',
	'*',
	';',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'i',
	'm',
	'p',
	'o',
	'r',
	't',
	' ',
	'j',
	'a',
	'v',
	'a',
	'.',
	'u',
	't',
	'i',
	'l',
	'.',
	'*',
	';',
	'\\',
	'n',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'p',
	'u',
	'b',
	'l',
	'i',
	'c',
	' ',
	'c',
	'l',
	'a',
	's',
	's',
	' ',
	'R',
	'e',
	'p',
	'l',
	'i',
	'c',
	'a',
	't',
	'o',
	'r',
	'{',
	'\\',
	'n',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'\\',
	't',
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
	'c',
	'h',
	'a',
	'r',
	'[',
	']',
	' ',
	's',
	' ',
	'=',
	' ',
	'{',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\n',
	'\t',
	'\t',
	'f',
	'o',
	'r',
	'(',
	'i',
	'n',
	't',
	' ',
	'i',
	' ',
	'=',
	' ',
	'0',
	';',
	' ',
	'i',
	' ',
	'<',
	' ',
	's',
	'.',
	'l',
	'e',
	'n',
	'g',
	't',
	'h',
	';',
	' ',
	'i',
	'+',
	'+',
	')',
	'{',
	'\n',
	'\n',
	'\t',
	'\t',
	'\t',
	'i',
	'f',
	'(',
	's',
	'[',
	'i',
	']',
	' ',
	'=',
	'=',
	' ',
	'\'',
	'\\',
	'n',
	'\'',
	')',
	'{',
	'\n',
	'\t',
	'\t',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'\\',
	't',
	'\\',
	'\'',
	'\\',
	'\\',
	'n',
	'\\',
	'\'',
	',',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'\t',
	'}',
	'\n',
	'\t',
	'\t',
	'\t',
	'e',
	'l',
	's',
	'e',
	' ',
	'i',
	'f',
	'(',
	's',
	'[',
	'i',
	']',
	' ',
	'=',
	'=',
	' ',
	'\'',
	'\\',
	'\'',
	'\'',
	')',
	'{',
	'\n',
	'\t',
	'\t',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'\\',
	't',
	'\\',
	'\'',
	'\\',
	'\\',
	'\'',
	'\\',
	'\'',
	',',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'\t',
	'}',
	'\n',
	'\t',
	'\t',
	'\t',
	'e',
	'l',
	's',
	'e',
	' ',
	'i',
	'f',
	'(',
	's',
	'[',
	'i',
	']',
	' ',
	'=',
	'=',
	' ',
	'\'',
	'\\',
	't',
	'\'',
	')',
	'{',
	'\n',
	'\t',
	'\t',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'\\',
	't',
	'\\',
	'\'',
	'\\',
	'\\',
	't',
	'\\',
	'\'',
	',',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'\t',
	'}',
	'\n',
	'\t',
	'\t',
	'\t',
	'e',
	'l',
	's',
	'e',
	' ',
	'i',
	'f',
	'(',
	's',
	'[',
	'i',
	']',
	' ',
	'=',
	'=',
	' ',
	'\'',
	'\\',
	'\"',
	'\'',
	')',
	'{',
	'\n',
	'\t',
	'\t',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'\\',
	't',
	'\\',
	'\'',
	'\\',
	'\\',
	'\\',
	'\"',
	'\\',
	'\'',
	',',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'\t',
	'}',
	'\n',
	'\t',
	'\t',
	'\t',
	'e',
	'l',
	's',
	'e',
	' ',
	'i',
	'f',
	'(',
	's',
	'[',
	'i',
	']',
	' ',
	'=',
	'=',
	' ',
	'\'',
	'\\',
	'\\',
	'\'',
	')',
	'{',
	'\n',
	'\t',
	'\t',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'\\',
	't',
	'\\',
	'\'',
	'\\',
	'\\',
	'\\',
	'\\',
	'\'',
	',',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'\t',
	'}',
	'\n',
	'\t',
	'\t',
	'\t',
	'e',
	'l',
	's',
	'e',
	'\n',
	'\t',
	'\t',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'\\',
	't',
	'\\',
	'\'',
	'%',
	'c',
	'\\',
	'\'',
	',',
	'\\',
	'n',
	'\"',
	',',
	' ',
	's',
	'[',
	'i',
	']',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'}',
	'\n',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'f',
	'(',
	'\"',
	'\\',
	'r',
	'\\',
	't',
	'}',
	';',
	'\\',
	'n',
	'\\',
	'n',
	'\"',
	')',
	';',
	'\n',
	'\n',
	'\t',
	'\t',
	'f',
	'o',
	'r',
	'(',
	'i',
	'n',
	't',
	' ',
	'i',
	' ',
	'=',
	' ',
	'0',
	';',
	' ',
	'i',
	' ',
	'<',
	' ',
	's',
	'.',
	'l',
	'e',
	'n',
	'g',
	't',
	'h',
	';',
	' ',
	'i',
	'+',
	'+',
	')',
	'{',
	'\n',
	'\t',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'p',
	'r',
	'i',
	'n',
	't',
	'(',
	's',
	'[',
	'i',
	']',
	')',
	';',
	'\n',
	'\t',
	'\t',
	'}',
	'\n',
	'\t',
	'\t',
	'w',
	'r',
	'i',
	't',
	'e',
	'r',
	'.',
	'c',
	'l',
	'o',
	's',
	'e',
	'(',
	')',
	';',
	'\n',
	'\t',
	'}',
	'\n',
	'}',

	};

	public static void main(String[] args) throws IOException {
		Random rand = new Random();
		String filename = "Replicator" + rand.nextInt() + ".java";
		PrintWriter writer = new PrintWriter(new FileWriter(filename));

		writer.printf("import java.io.*;\n");
		writer.printf("import java.util.*;\n\n");
		writer.printf("public class Replicator{\n\n");
		writer.printf("\tpublic static char[] s = {\n");

		for(int i = 0; i < s.length; i++){

			if(s[i] == '\n'){
				writer.printf("\t\'\\n\',\n");
			}
			else if(s[i] == '\''){
				writer.printf("\t\'\\'\',\n");
			}
			else if(s[i] == '\t'){
				writer.printf("\t\'\\t\',\n");
			}
			else if(s[i] == '\"'){
				writer.printf("\t\'\\\"\',\n");
			}
			else if(s[i] == '\\'){
				writer.printf("\t\'\\\\',\n");
			}
			else
				writer.printf("\t\'%c\',\n", s[i]);
		}
		writer.printf("\r\t};\n\n");

		for(int i = 0; i < s.length; i++){
			writer.print(s[i]);
		}
		writer.close();
	}
}