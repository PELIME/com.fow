package test2;


import java.io.StreamTokenizer;

public class Tset2 {
    public static void main(String[] args) {
        try{
            StreamTokenizer st=new StreamTokenizer(System.in);
            st.wordChars(' ',' ');
            st.quoteChar(';');
            while (st.nextToken()!=StreamTokenizer.TT_EOF)
            {
                String s="";
                switch (st.ttype) {
                    case ';':
                        s = st.sval;
                        break;
                    default:
                        s = st.sval;
                }
                System.out.println(st.toString());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
