/*      */ package org.apache.xmlbeans.impl.piccolo.xml;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.PrintWriter;
/*      */ import java.io.StringWriter;
/*      */ import java.net.MalformedURLException;
/*      */ import java.util.Locale;
/*      */ import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
/*      */ import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;
/*      */ import org.apache.xmlbeans.impl.piccolo.util.DuplicateKeyException;
/*      */ import org.xml.sax.ContentHandler;
/*      */ import org.xml.sax.DTDHandler;
/*      */ import org.xml.sax.DocumentHandler;
/*      */ import org.xml.sax.EntityResolver;
/*      */ import org.xml.sax.ErrorHandler;
/*      */ import org.xml.sax.InputSource;
/*      */ import org.xml.sax.Locator;
/*      */ import org.xml.sax.Parser;
/*      */ import org.xml.sax.SAXException;
/*      */ import org.xml.sax.SAXNotRecognizedException;
/*      */ import org.xml.sax.SAXNotSupportedException;
/*      */ import org.xml.sax.SAXParseException;
/*      */ import org.xml.sax.XMLReader;
/*      */ import org.xml.sax.ext.DeclHandler;
/*      */ import org.xml.sax.ext.LexicalHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Piccolo
/*      */   implements Locator, Parser, XMLReader
/*      */ {
/*      */   boolean yydebug;
/*      */   int yynerrs;
/*      */   int yyerrflag;
/*      */   int yychar;
/*      */   static final int YYSTACKSIZE = 500;
/*      */   
/*      */   void debug(String paramString) {
/*   79 */     if (this.yydebug) {
/*   80 */       System.out.println(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*   85 */   int[] statestk = new int[500];
/*      */   int stateptr;
/*      */   int stateptrmax;
/*      */   int statemax;
/*      */   String yytext;
/*      */   String yyval;
/*      */   String yylval;
/*      */   
/*      */   final void state_push(int paramInt) {
/*      */     try {
/*   95 */       this.stateptr++;
/*   96 */       this.statestk[this.stateptr] = paramInt;
/*      */     }
/*   98 */     catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*   99 */       int i = this.statestk.length;
/*  100 */       int j = i * 2;
/*  101 */       int[] arrayOfInt = new int[j];
/*  102 */       System.arraycopy(this.statestk, 0, arrayOfInt, 0, i);
/*  103 */       this.statestk = arrayOfInt;
/*  104 */       this.statestk[this.stateptr] = paramInt;
/*      */     } 
/*      */   }
/*      */   
/*      */   final int state_pop() {
/*  109 */     return this.statestk[this.stateptr--];
/*      */   }
/*      */   
/*      */   final void state_drop(int paramInt) {
/*  113 */     this.stateptr -= paramInt;
/*      */   }
/*      */   
/*      */   final int state_peek(int paramInt) {
/*  117 */     return this.statestk[this.stateptr - paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final boolean init_stacks() {
/*  124 */     this.stateptr = -1;
/*  125 */     val_init();
/*  126 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void dump_stacks(int paramInt) {
/*  134 */     System.out.println("=index==state====value=     s:" + this.stateptr + "  v:" + this.valptr);
/*  135 */     for (byte b = 0; b < paramInt; b++)
/*  136 */       System.out.println(" " + b + "    " + this.statestk[b] + "      " + this.valstk[b]); 
/*  137 */     System.out.println("======================");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  146 */   String[] valstk = new String[500]; int valptr; public static final short CDATA = 257; public static final short TAG_END = 258; public static final short PI = 259; public static final short NAME = 260; public static final short STRING = 261; public static final short EQ = 262; public static final short OPEN_TAG = 263; public static final short CLOSE_TAG = 264; public static final short EMPTY_TAG = 265; public static final short WHITESPACE = 266; public static final short DTD_START = 267; public static final short DTD_START_SKIPEXTERNAL = 268; public static final short SYSTEM = 269; public static final short PUBLIC = 270; public static final short REQUIRED = 271; public static final short IMPLIED = 272; public static final short FIXED = 273; public static final short LPAREN = 274; public static final short RPAREN = 275; public static final short LBRACKET = 276; public static final short PIPE = 277; public static final short ENTITY_DECL_START = 278; public static final short ATTLIST_START = 279; public static final short NOTATION_START = 280; public static final short RBRACKET_END = 281; public static final short DOUBLE_RBRACKET_END = 282; public static final short PERCENT = 283; public static final short ENUMERATION = 284; public static final short NOTATION = 285; public static final short ID = 286; public static final short IDREF = 287; public static final short IDREFS = 288; public static final short ENTITY = 289; public static final short ENTITIES = 290; public static final short NMTOKEN = 291; public static final short NMTOKENS = 292; public static final short ENTITY_REF = 293; public static final short ENTITY_END = 294; public static final short INTERNAL_ENTITY_REF = 295; public static final short EXTERNAL_ENTITY_REF = 296; public static final short SKIPPED_ENTITY_REF = 297; public static final short PREFIXED_NAME = 298; public static final short UNPREFIXED_NAME = 299; public static final short NDATA = 300; public static final short COMMENT = 301; public static final short CONDITIONAL_START = 302; public static final short IGNORED_CONDITIONAL_START = 303; public static final short INCLUDE = 304; public static final short IGNORE = 305; public static final short MODIFIER = 306; public static final short PCDATA = 307; public static final short ELEMENT_DECL_START = 308; public static final short EMPTY = 309; public static final short ANY = 310; public static final short STAR = 311; public static final short COMMA = 312; public static final short QUESTION = 313; public static final short PLUS = 314;
/*      */   public static final short XML_DOC_DECL = 315;
/*      */   public static final short XML_TEXT_DECL = 316;
/*      */   public static final short XML_DOC_OR_TEXT_DECL = 317;
/*      */   public static final short YYERRCODE = 256;
/*      */   
/*      */   final void val_init() {
/*  153 */     this.yyval = new String();
/*  154 */     this.yylval = new String();
/*  155 */     this.valptr = -1;
/*      */   }
/*      */   
/*      */   final void val_push(String paramString) {
/*      */     try {
/*  160 */       this.valptr++;
/*  161 */       this.valstk[this.valptr] = paramString;
/*      */     }
/*  163 */     catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*  164 */       int i = this.valstk.length;
/*  165 */       int j = i * 2;
/*  166 */       String[] arrayOfString = new String[j];
/*  167 */       System.arraycopy(this.valstk, 0, arrayOfString, 0, i);
/*  168 */       this.valstk = arrayOfString;
/*  169 */       this.valstk[this.valptr] = paramString;
/*      */     } 
/*      */   }
/*      */   
/*      */   final String val_pop() {
/*  174 */     return this.valstk[this.valptr--];
/*      */   }
/*      */   
/*      */   final void val_drop(int paramInt) {
/*  178 */     this.valptr -= paramInt;
/*      */   }
/*      */   
/*      */   final String val_peek(int paramInt) {
/*  182 */     return this.valstk[this.valptr - paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  247 */   static final short[] yylhs = new short[] { -1, 0, 0, 1, 1, 1, 5, 5, 3, 3, 3, 4, 4, 7, 7, 7, 8, 8, 9, 9, 2, 2, 2, 2, 2, 2, 12, 12, 14, 14, 10, 10, 10, 13, 13, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 15, 15, 20, 20, 21, 21, 22, 22, 16, 16, 16, 16, 16, 16, 18, 18, 17, 23, 24, 24, 25, 25, 25, 25, 25, 25, 25, 25, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 27, 27, 19, 28, 28, 28, 28, 29, 29, 29, 29, 30, 30, 30, 34, 34, 36, 36, 35, 35, 35, 35, 31, 31, 33, 33, 32, 32, 32, 32, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  262 */   static final short[] yylen = new short[] { 2, 4, 3, 1, 1, 0, 1, 1, 1, 3, 2, 2, 0, 1, 1, 1, 1, 2, 0, 1, 4, 3, 4, 3, 6, 2, 2, 4, 7, 9, 3, 3, 5, 3, 5, 0, 2, 2, 2, 2, 2, 2, 3, 3, 4, 4, 4, 3, 2, 3, 2, 0, 4, 7, 7, 11, 8, 8, 11, 7, 9, 4, 3, 0, 3, 5, 5, 5, 5, 7, 7, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 5, 7, 1, 5, 7, 1, 1, 1, 1, 6, 5, 10, 2, 2, 2, 2, 5, 5, 1, 4, 3, 3, 3, 2, 4, 2, 4, 2, 1, 1, 1, 0, 0, 4, 4, 5, 4, 2, 2, 2, 2, 2 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  277 */   static final short[] yydefred = new short[] { 0, 3, 4, 0, 0, 14, 113, 8, 13, 0, 0, 15, 0, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0, 2, 0, 25, 10, 0, 6, 7, 35, 0, 26, 35, 122, 119, 113, 9, 118, 121, 113, 0, 120, 16, 30, 0, 0, 31, 0, 1, 11, 0, 0, 0, 21, 35, 0, 0, 0, 40, 36, 37, 38, 39, 41, 63, 0, 23, 0, 0, 0, 113, 0, 17, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, 0, 35, 51, 0, 0, 22, 27, 117, 114, 0, 115, 0, 0, 0, 0, 32, 0, 0, 0, 0, 62, 0, 0, 0, 0, 16, 48, 50, 0, 0, 0, 0, 0, 116, 0, 0, 33, 0, 24, 0, 0, 0, 47, 49, 45, 46, 51, 0, 0, 0, 64, 61, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 87, 0, 88, 89, 0, 0, 0, 0, 0, 34, 0, 0, 0, 0, 0, 0, 0, 0, 52, 0, 93, 96, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 109, 111, 94, 95, 73, 0, 0, 74, 75, 76, 77, 78, 79, 80, 0, 0, 29, 53, 0, 54, 0, 0, 0, 0, 59, 0, 0, 0, 0, 104, 0, 0, 0, 0, 0, 0, 85, 0, 0, 0, 0, 0, 56, 57, 0, 0, 0, 101, 0, 102, 103, 105, 0, 0, 107, 83, 0, 0, 71, 65, 67, 0, 72, 66, 68, 0, 0, 0, 60, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 90, 0, 98, 0, 0, 81, 0, 0, 69, 70, 55, 58, 0, 0, 0, 0, 0, 84, 82, 0, 92 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  308 */   static final short[] yydgoto = new short[] { 3, 4, 12, 26, 23, 30, 18, 59, 104, 46, 15, 27, 16, 79, 17, 60, 61, 62, 63, 64, 89, 90, 117, 65, 92, 138, 202, 244, 154, 173, 174, 181, 190, 182, 183, 184, 185 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  314 */   static final short[] yysindex = new short[] { -120, 0, 0, 0, 181, 0, 0, 0, 0, -213, -166, 0, -250, -248, 181, 0, -10, -206, -119, -239, -188, -248, -250, 0, -248, 0, 0, -41, 0, 0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0, 165, -237, 0, 225, 0, 0, -194, -194, -194, 0, 0, -10, -223, -194, 0, 0, 0, 0, 0, 0, 0, -7, 0, 18, 102, 117, 0, 127, 0, -194, -194, 0, -194, -194, -137, -146, -88, -54, 77, 0, 77, -194, -194, -209, 0, 0, -24, -194, 0, 0, 0, 0, 142, 0, -108, -76, -53, -15, 0, -135, -117, -194, -79, 0, -194, 77, -66, -59, 0, 0, 0, 43, -139, -194, -147, -32, 0, -194, -194, 0, -194, 0, 204, 227, 232, 0, 0, 0, 0, 0, -264, -194, -194, 0, 0, 0, 15, 76, -194, -194, 210, -194, -194, -194, -133, -103, -86, 0, 0, -194, 0, 0, 106, 106, 198, 198, -194, 0, 16, -235, 35, -194, -194, -192, 97, 92, 0, -103, 0, 0, 106, 106, 106, -55, -55, 55, 106, 106, -194, -194, -194, 113, 0, 0, 0, 0, 0, 0, -194, -194, 0, 0, 0, 0, 0, 0, 0, -194, -194, 0, 0, -194, 0, 123, 130, -194, -194, 0, -194, -55, 106, 106, 0, -194, -194, -194, 49, -251, 116, 0, 135, -39, 44, 143, 67, 0, 0, 68, 76, 144, 0, -28, 0, 0, 0, -194, -55, 0, 0, -194, -194, 0, 0, 0, -194, 0, 0, 0, -194, -194, -194, 0, 89, -194, -55, -194, 0, 112, 135, 103, 109, 148, 152, 0, 135, 0, -194, 65, 0, -194, -194, 0, 0, 0, 0, -194, 168, 169, 119, 150, 0, 0, 131, 0 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  345 */   static final short[] yyrindex = new short[] { 191, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 452, 0, 0, 52, 0, 0, 202, 0, 452, 0, 0, 452, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 167, 0, 0, 0, 208, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 202, 0, 0, 0, -50, 0, -12, 193, 193, 0, 0, 0, 0, 202, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -153, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 208, 0, 0, -178, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 202, 202, 0, 0, 0, 202, 0, 31, 160, 0, 0, 202, 0, 0, -25, -25, 0, 0, -178, 0, 0, 208, 0, 202, 202, 0, 0, 0, 0, 0, 0, 0, -13, 17, -263, 170, 0, 0, -263, -263, 200, -186, 200, 0, 0, 0, 0, 0, 0, 0, 218, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 202, 0, -164, 0, -258, -200, 0, 164, -164, -164, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 208, 0, 0, 0, 0, 0, 0, -124, 0, 0, 0, 164, 218, 0, 0, 0, 0, 0, 0, 0, 0, 202, 202, 0, 42, 218, 0, -252, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 176, 0, 0, 218, 164, 0, 0, 0, 0, 164, 0, 0, 0, 0, 0, 0, 0, 0 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  376 */   static final short[] yygindex = new short[] { 0, 0, 467, 300, 328, 27, 125, 244, -19, -51, 0, 46, 0, 28, 0, 0, 0, 0, 0, 0, 411, 412, 369, 0, 0, 0, 344, 66, 0, 370, 371, -130, -152, -128, 248, -174, 267 };
/*      */ 
/*      */ 
/*      */   
/*      */   static final int YYTABLESIZE = 508;
/*      */ 
/*      */   
/*  383 */   static final short[] yytable = new short[] { 45, 48, 150, 112, 217, 157, 191, 158, 106, 5, 151, 5, 112, 6, 112, 7, 8, 106, 8, 106, 175, 76, 176, 99, 191, 213, 240, 43, 105, 219, 220, 73, 80, 81, 82, 111, 112, 44, 88, 91, 217, 120, 175, 43, 176, 152, 153, 19, 215, 112, 216, 11, 32, 11, 106, 99, 100, 113, 101, 102, 18, 241, 31, 219, 220, 206, 108, 260, 71, 88, 33, 140, 43, 119, 73, 108, 66, 108, 43, 68, 18, 86, 87, 84, 215, 271, 216, 127, 47, 99, 129, 18, 163, 165, 20, 86, 87, 170, 18, 135, 180, 83, 85, 186, 141, 19, 142, 19, 210, 145, 204, 18, 108, 18, 106, 208, 209, 159, 160, 73, 73, 19, 19, 19, 19, 164, 18, 168, 169, 43, 110, 73, 221, 222, 223, 116, 18, 107, 34, 103, 35, 126, 225, 133, 36, 37, 38, 39, 18, 171, 18, 136, 137, 122, 19, 144, 146, 148, 73, 19, 234, 69, 235, 172, 134, 70, 72, 236, 237, 238, 134, 151, 108, 167, 177, 226, 40, 41, 73, 35, 178, 128, 42, 227, 228, 123, 35, 229, 179, 259, 73, 232, 233, 262, 263, 1, 97, 2, 35, 35, 35, 35, 35, 266, 267, 177, 109, 269, 124, 272, 130, 214, 73, 73, 35, 35, 35, 131, 5, 179, 281, 35, 35, 282, 283, 8, 139, 73, 35, 284, 264, 42, 42, 112, 265, 245, 118, 51, 52, 53, 54, 112, 73, 5, 42, 106, 125, 257, 14, 258, 8, 73, 5, 106, 55, 56, 22, 24, 14, 8, 11, 57, 51, 52, 53, 24, 22, 58, 24, 43, 43, 51, 52, 53, 205, 108, 161, 5, 67, 55, 56, 73, 43, 108, 8, 11, 57, 93, 55, 56, 44, 44, 58, 207, 11, 57, 51, 52, 53, 94, 91, 58, 5, 44, 13, 246, 28, 29, 91, 8, 73, 35, 21, 55, 56, 247, 248, 249, 35, 11, 57, 51, 52, 53, 239, 132, 58, 254, 255, 275, 35, 35, 35, 73, 73, 280, 5, 162, 55, 56, 17, 17, 73, 8, 11, 57, 35, 35, 35, 49, 212, 58, 50, 35, 35, 51, 52, 53, 211, 34, 35, 35, 218, 73, 276, 36, 95, 38, 39, 73, 277, 224, 55, 56, 34, 73, 35, 241, 11, 57, 36, 230, 38, 39, 34, 58, 35, 273, 231, 274, 36, 242, 38, 39, 286, 243, 274, 40, 41, 34, 268, 35, 256, 42, 250, 36, 278, 38, 39, 73, 279, 96, 40, 41, 251, 252, 253, 187, 42, 188, 189, 98, 40, 41, 113, 287, 113, 274, 42, 285, 113, 73, 113, 113, 74, 75, 121, 40, 41, 18, 5, 18, 288, 42, 6, 240, 7, 8, 9, 10, 5, 97, 12, 18, 5, 192, 5, 5, 5, 5, 18, 113, 113, 113, 73, 143, 19, 18, 113, 18, 73, 166, 193, 77, 78, 18, 73, 16, 18, 77, 78, 25, 11, 194, 195, 196, 197, 198, 199, 200, 201, 73, 5, 43, 77, 78, 77, 78, 73, 114, 115, 77, 147, 149, 203, 155, 156, 270, 261 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  436 */   static final short[] yycheck = new short[] { 19, 20, 266, 266, 178, 135, 158, 135, 266, 259, 274, 259, 275, 263, 277, 265, 266, 275, 266, 277, 150, 258, 150, 275, 176, 177, 277, 266, 79, 181, 182, 266, 51, 52, 53, 86, 87, 276, 57, 58, 214, 92, 172, 266, 172, 309, 310, 260, 178, 312, 178, 301, 258, 301, 312, 74, 75, 266, 77, 78, 312, 312, 16, 215, 216, 300, 266, 241, 41, 88, 276, 122, 266, 92, 266, 275, 30, 277, 266, 33, 258, 304, 305, 56, 214, 259, 214, 106, 276, 275, 109, 277, 143, 144, 260, 304, 305, 148, 276, 118, 151, 55, 56, 154, 123, 258, 125, 260, 300, 128, 161, 275, 312, 277, 260, 166, 167, 136, 137, 266, 266, 274, 275, 276, 277, 144, 312, 146, 147, 266, 84, 266, 183, 184, 185, 89, 260, 283, 257, 276, 259, 258, 193, 282, 263, 264, 265, 266, 312, 282, 274, 298, 299, 261, 307, 127, 128, 129, 266, 312, 211, 36, 213, 266, 303, 40, 41, 218, 219, 220, 303, 274, 260, 145, 260, 194, 295, 296, 266, 259, 266, 260, 301, 202, 203, 261, 266, 206, 274, 240, 266, 210, 211, 244, 245, 315, 71, 317, 278, 279, 280, 281, 282, 254, 255, 260, 260, 258, 261, 260, 276, 266, 266, 266, 294, 295, 296, 276, 259, 274, 271, 301, 302, 274, 275, 266, 258, 266, 308, 280, 249, 281, 282, 258, 253, 274, 260, 278, 279, 280, 281, 266, 266, 259, 294, 258, 261, 275, 4, 277, 266, 266, 259, 266, 295, 296, 12, 13, 14, 266, 301, 302, 278, 279, 280, 21, 22, 308, 24, 281, 282, 278, 279, 280, 258, 258, 261, 259, 294, 295, 296, 266, 294, 266, 266, 301, 302, 294, 295, 296, 281, 282, 308, 258, 301, 302, 278, 279, 280, 281, 258, 308, 259, 294, 4, 261, 316, 317, 266, 266, 266, 259, 12, 295, 296, 271, 272, 273, 266, 301, 302, 278, 279, 280, 275, 282, 308, 260, 260, 263, 278, 279, 280, 266, 266, 269, 259, 261, 295, 296, 309, 310, 266, 266, 301, 302, 294, 295, 296, 21, 258, 308, 24, 301, 302, 278, 279, 280, 261, 257, 308, 259, 307, 266, 261, 263, 264, 265, 266, 266, 261, 258, 295, 296, 257, 266, 259, 312, 301, 302, 263, 258, 265, 266, 257, 308, 259, 275, 258, 277, 263, 275, 265, 266, 275, 260, 277, 295, 296, 257, 311, 259, 258, 301, 261, 263, 258, 265, 266, 266, 258, 294, 295, 296, 271, 272, 273, 311, 301, 313, 314, 294, 295, 296, 257, 275, 259, 277, 301, 260, 263, 266, 265, 266, 269, 270, 294, 295, 296, 275, 259, 277, 311, 301, 263, 277, 265, 266, 267, 268, 259, 275, 0, 277, 263, 257, 265, 266, 267, 268, 258, 294, 295, 296, 266, 261, 258, 307, 301, 276, 266, 261, 274, 269, 270, 275, 266, 307, 260, 269, 270, 14, 301, 285, 286, 287, 288, 289, 290, 291, 292, 266, 301, 266, 269, 270, 269, 270, 266, 88, 88, 269, 270, 134, 160, 135, 135, 259, 241 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final short YYFINAL = 3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final short YYMAXTOKEN = 317;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  491 */   static final String[] yyname = new String[] { "end-of-file", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "CDATA", "TAG_END", "PI", "NAME", "STRING", "EQ", "OPEN_TAG", "CLOSE_TAG", "EMPTY_TAG", "WHITESPACE", "DTD_START", "DTD_START_SKIPEXTERNAL", "SYSTEM", "PUBLIC", "REQUIRED", "IMPLIED", "FIXED", "LPAREN", "RPAREN", "LBRACKET", "PIPE", "ENTITY_DECL_START", "ATTLIST_START", "NOTATION_START", "RBRACKET_END", "DOUBLE_RBRACKET_END", "PERCENT", "ENUMERATION", "NOTATION", "ID", "IDREF", "IDREFS", "ENTITY", "ENTITIES", "NMTOKEN", "NMTOKENS", "ENTITY_REF", "ENTITY_END", "INTERNAL_ENTITY_REF", "EXTERNAL_ENTITY_REF", "SKIPPED_ENTITY_REF", "PREFIXED_NAME", "UNPREFIXED_NAME", "NDATA", "COMMENT", "CONDITIONAL_START", "IGNORED_CONDITIONAL_START", "INCLUDE", "IGNORE", "MODIFIER", "PCDATA", "ELEMENT_DECL_START", "EMPTY", "ANY", "STAR", "COMMA", "QUESTION", "PLUS", "XML_DOC_DECL", "XML_TEXT_DECL", "XML_DOC_OR_TEXT_DECL" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  520 */   static final String[] yyrule = new String[] { "$accept : document", "document : xml_decl dtd body epilog", "document : xml_decl body epilog", "xml_decl : XML_DOC_DECL", "xml_decl : XML_DOC_OR_TEXT_DECL", "xml_decl :", "xml_text_decl : XML_TEXT_DECL", "xml_text_decl : XML_DOC_OR_TEXT_DECL", "body : EMPTY_TAG", "body : OPEN_TAG content CLOSE_TAG", "body : misc body", "epilog : misc epilog", "epilog :", "misc : WHITESPACE", "misc : PI", "misc : COMMENT", "ws : WHITESPACE", "ws : ws WHITESPACE", "opt_ws :", "opt_ws : ws", "dtd : DTD_START NAME opt_ws TAG_END", "dtd : dtd_only_internal_start dtd_content RBRACKET_END", "dtd : dtd_with_external xml_text_decl dtd_content ENTITY_END", "dtd : dtd_with_external dtd_content ENTITY_END", "dtd : DTD_START_SKIPEXTERNAL NAME ws external_id opt_ws TAG_END", "dtd : misc dtd", "dtd_with_external : dtd_with_external_start TAG_END", "dtd_with_external : dtd_with_external_start LBRACKET dtd_content RBRACKET_END", "dtd_with_external_start : DTD_START NAME ws SYSTEM ws STRING opt_ws", "dtd_with_external_start : DTD_START NAME ws PUBLIC ws STRING ws STRING opt_ws", "dtd_only_internal_start : DTD_START NAME LBRACKET", "dtd_only_internal_start : DTD_START_SKIPEXTERNAL NAME LBRACKET", "dtd_only_internal_start : DTD_START_SKIPEXTERNAL NAME ws external_id LBRACKET", "external_id : SYSTEM ws STRING", "external_id : PUBLIC ws STRING ws STRING", "dtd_content :", "dtd_content : dtd_content dtd_conditional", "dtd_content : dtd_content dtd_entity", "dtd_content : dtd_content dtd_attlist", "dtd_content : dtd_content dtd_notation", "dtd_content : dtd_content misc", "dtd_content : dtd_content dtd_element", "dtd_content : dtd_content INTERNAL_ENTITY_REF dtd_content", "dtd_content : dtd_content EXTERNAL_ENTITY_REF dtd_content", "dtd_content : dtd_content EXTERNAL_ENTITY_REF xml_text_decl dtd_content", "dtd_conditional : CONDITIONAL_START dtd_include dtd_content DOUBLE_RBRACKET_END", "dtd_conditional : CONDITIONAL_START dtd_ignore ignored_dtd_content DOUBLE_RBRACKET_END", "dtd_include : INCLUDE opt_ws LBRACKET", "dtd_include : ws dtd_include", "dtd_ignore : IGNORE opt_ws LBRACKET", "dtd_ignore : ws dtd_ignore", "ignored_dtd_content :", "ignored_dtd_content : ignored_dtd_content IGNORED_CONDITIONAL_START ignored_dtd_content DOUBLE_RBRACKET_END", "dtd_entity : ENTITY_DECL_START ws NAME ws STRING opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws NAME ws external_id opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws NAME ws external_id ws NDATA ws NAME opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws PERCENT NAME ws STRING opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws PERCENT NAME ws external_id opt_ws TAG_END", "dtd_entity : ENTITY_DECL_START ws PERCENT NAME external_id ws NDATA ws NAME opt_ws TAG_END", "dtd_notation : NOTATION_START ws NAME ws external_id opt_ws TAG_END", "dtd_notation : NOTATION_START ws NAME ws PUBLIC ws STRING opt_ws TAG_END", "dtd_attlist : attlist_start att_def_list opt_ws TAG_END", "attlist_start : ATTLIST_START ws NAME", "att_def_list :", "att_def_list : att_def_list ws att_def", "att_def : PREFIXED_NAME ws att_type ws REQUIRED", "att_def : UNPREFIXED_NAME ws att_type ws REQUIRED", "att_def : PREFIXED_NAME ws att_type ws IMPLIED", "att_def : UNPREFIXED_NAME ws att_type ws IMPLIED", "att_def : PREFIXED_NAME ws att_type ws FIXED ws STRING", "att_def : UNPREFIXED_NAME ws att_type ws FIXED ws STRING", "att_def : PREFIXED_NAME ws att_type ws STRING", "att_def : UNPREFIXED_NAME ws att_type ws STRING", "att_type : CDATA", "att_type : ID", "att_type : IDREF", "att_type : IDREFS", "att_type : ENTITY", "att_type : ENTITIES", "att_type : NMTOKEN", "att_type : NMTOKENS", "att_type : LPAREN opt_ws word_list opt_ws RPAREN", "att_type : NOTATION ws LPAREN opt_ws word_list opt_ws RPAREN", "word_list : NAME", "word_list : word_list opt_ws PIPE opt_ws NAME", "dtd_element : ELEMENT_DECL_START ws NAME ws element_spec opt_ws TAG_END", "element_spec : EMPTY", "element_spec : ANY", "element_spec : element_spec_mixed", "element_spec : element_spec_children", "element_spec_mixed : LPAREN opt_ws PCDATA opt_ws RPAREN STAR", "element_spec_mixed : LPAREN opt_ws PCDATA opt_ws RPAREN", "element_spec_mixed : LPAREN opt_ws PCDATA opt_ws PIPE opt_ws word_list opt_ws RPAREN STAR", "element_spec_mixed : WHITESPACE element_spec_mixed", "element_spec_children : element_choice element_modifier", "element_spec_children : element_seq element_modifier", "element_spec_children : WHITESPACE element_spec_children", "element_cp_pipe_list : element_cp opt_ws PIPE opt_ws element_cp", "element_cp_pipe_list : element_cp opt_ws PIPE opt_ws element_cp_pipe_list", "element_cp_comma_list : element_cp", "element_cp_comma_list : element_cp opt_ws COMMA element_cp_comma_list", "element_cp : NAME element_modifier opt_ws", "element_cp : element_choice element_modifier opt_ws", "element_cp : element_seq element_modifier opt_ws", "element_cp : WHITESPACE element_cp", "element_choice : LPAREN element_cp_pipe_list opt_ws RPAREN", "element_choice : WHITESPACE element_choice", "element_seq : LPAREN element_cp_comma_list opt_ws RPAREN", "element_seq : WHITESPACE element_seq", "element_modifier : QUESTION", "element_modifier : STAR", "element_modifier : PLUS", "element_modifier :", "content :", "content : content INTERNAL_ENTITY_REF content ENTITY_END", "content : content EXTERNAL_ENTITY_REF content ENTITY_END", "content : content EXTERNAL_ENTITY_REF xml_text_decl content ENTITY_END", "content : content OPEN_TAG content CLOSE_TAG", "content : content EMPTY_TAG", "content : content PI", "content : content COMMENT", "content : content WHITESPACE", "content : content CDATA" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  648 */   DocumentHandler documentHandler = null;
/*  649 */   DTDHandler dtdHandler = null;
/*  650 */   ErrorHandler errorHandler = null;
/*  651 */   ContentHandler contentHandler = null;
/*  652 */   int saxVersion = 0;
/*  653 */   int attributeType = -1;
/*  654 */   StringBuffer modelBuffer = new StringBuffer(100);
/*  655 */   ElementDefinition elementDefinition = null;
/*  656 */   String pubID = null, sysID = null;
/*  657 */   String dtdName = null; String dtdPubID = null; String dtdSysID = null;
/*  658 */   PiccoloLexer lexer = new PiccoloLexer(this);
/*  659 */   DocumentEntity docEntity = new DocumentEntity();
/*  660 */   LexicalHandler lexHandler = null;
/*  661 */   DeclHandler declHandler = null;
/*      */   
/*      */   boolean parsingInProgress = false;
/*      */   
/*      */   private StartLocator startLocator;
/*      */   
/*      */   boolean fNamespaces;
/*      */   
/*      */   boolean fNamespacePrefixes;
/*      */   
/*      */   boolean fResolveDTDURIs;
/*      */   
/*      */   boolean fExternalGeneralEntities;
/*      */   boolean fExternalParameterEntities;
/*      */   boolean fLexicalParameterEntities;
/*      */   private char[] oneCharBuffer;
/*      */   int yyn;
/*      */   int yym;
/*      */   int yystate;
/*      */   String yys;
/*      */   
/*      */   private void reset() {
/*  683 */     this.modelBuffer.setLength(0);
/*  684 */     this.pubID = this.sysID = this.dtdName = this.dtdPubID = this.dtdSysID = null;
/*  685 */     this.elementDefinition = null;
/*      */   }
/*      */ 
/*      */   
/*      */   private void validateParseState() throws SAXException {
/*  690 */     if (!this.fNamespaces && !this.fNamespacePrefixes)
/*  691 */       throw new FatalParsingException("The 'namespaces' and 'namespace-prefixes' features must not both be false"); 
/*      */   }
/*      */   
/*      */   public void setDebug(boolean paramBoolean) {
/*  695 */     this.yydebug = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void parse(InputSource paramInputSource) throws IOException, SAXException {
/*      */     try {
/*  705 */       reset();
/*  706 */       validateParseState();
/*      */       try {
/*  708 */         this.docEntity.reset(paramInputSource);
/*  709 */         this.lexer.reset(this.docEntity);
/*      */       } finally {
/*      */         
/*  712 */         reportStartDocument();
/*      */       } 
/*  714 */       yyparse();
/*      */     }
/*  716 */     catch (IllegalCharException illegalCharException) {
/*  717 */       reportFatalError(illegalCharException.getMessage(), (Exception)illegalCharException);
/*      */     }
/*  719 */     catch (FileFormatException fileFormatException) {
/*  720 */       reportFatalError(fileFormatException.getMessage(), (Exception)fileFormatException);
/*      */     }
/*  722 */     catch (FatalParsingException fatalParsingException) {
/*  723 */       reportFatalError(fatalParsingException.getMessage(), fatalParsingException.getException());
/*      */     } finally {
/*      */       
/*  726 */       reportEndDocument();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void parse(String paramString) throws IOException, SAXException {
/*      */     try {
/*  734 */       reset();
/*  735 */       validateParseState();
/*      */       try {
/*  737 */         this.docEntity.reset(paramString);
/*  738 */         this.lexer.reset(this.docEntity);
/*      */       } finally {
/*      */         
/*  741 */         reportStartDocument();
/*      */       } 
/*  743 */       yyparse();
/*      */     }
/*  745 */     catch (IllegalCharException illegalCharException) {
/*  746 */       reportFatalError(illegalCharException.getMessage(), (Exception)illegalCharException);
/*      */     }
/*  748 */     catch (FileFormatException fileFormatException) {
/*  749 */       reportFatalError(fileFormatException.getMessage(), (Exception)fileFormatException);
/*      */     }
/*  751 */     catch (FatalParsingException fatalParsingException) {
/*  752 */       reportFatalError(fatalParsingException.getMessage(), fatalParsingException.getException());
/*      */     } finally {
/*      */       
/*  755 */       reportEndDocument();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDocumentHandler(DocumentHandler paramDocumentHandler) {
/*  765 */     this.documentHandler = paramDocumentHandler;
/*  766 */     if (this.documentHandler != null) {
/*  767 */       this.saxVersion = 1;
/*  768 */       this.fNamespaces = false;
/*  769 */       this.lexer.enableNamespaces(false);
/*  770 */       this.fNamespacePrefixes = true;
/*  771 */       this.documentHandler.setDocumentLocator(this);
/*      */     } else {
/*      */       
/*  774 */       this.saxVersion = 0;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setDTDHandler(DTDHandler paramDTDHandler) {
/*  779 */     this.dtdHandler = paramDTDHandler;
/*      */   }
/*      */   
/*      */   public void setEntityResolver(EntityResolver paramEntityResolver) {
/*  783 */     this.lexer.entityManager.setResolver(paramEntityResolver);
/*      */   }
/*      */   
/*      */   public void setErrorHandler(ErrorHandler paramErrorHandler) {
/*  787 */     this.errorHandler = paramErrorHandler;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setLocale(Locale paramLocale) throws SAXException {
/*  792 */     if (!"en".equals(paramLocale.getLanguage()))
/*  793 */       throw new SAXException("Only English (EN) locales are supported"); 
/*      */   }
/*      */   
/*      */   public int getColumnNumber() {
/*  797 */     return this.lexer.getColumnNumber();
/*  798 */   } public int getLineNumber() { return this.lexer.getLineNumber(); }
/*  799 */   public String getPublicId() { return this.lexer.getPublicID(); } public String getSystemId() {
/*  800 */     return this.lexer.getSystemID();
/*      */   }
/*      */   private class StartLocator implements Locator { private final Piccolo this$0;
/*      */     private StartLocator() {}
/*      */     
/*  805 */     public int getLineNumber() { return Piccolo.this.lexer.tokenStartLine; }
/*  806 */     public int getColumnNumber() { return Piccolo.this.lexer.tokenStartColumn; }
/*  807 */     public String getPublicId() { return null; } public String getSystemId() {
/*  808 */       return null;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Locator getStartLocator() {
/*  815 */     if (this.startLocator == null) {
/*  816 */       this.startLocator = new StartLocator();
/*      */     }
/*  818 */     return this.startLocator;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getVersion() {
/*  823 */     return this.lexer.getVersion();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getEncoding() {
/*  828 */     return this.lexer.getEncoding();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ContentHandler getContentHandler() {
/*  835 */     return this.contentHandler;
/*      */   }
/*      */   public void setContentHandler(ContentHandler paramContentHandler) {
/*  838 */     this.contentHandler = paramContentHandler;
/*      */     
/*  840 */     if (this.contentHandler != null) {
/*      */       
/*  842 */       if (this.saxVersion == 1) {
/*  843 */         this.fNamespaces = true;
/*  844 */         this.lexer.enableNamespaces(true);
/*  845 */         this.fNamespacePrefixes = false;
/*      */       } 
/*      */       
/*  848 */       this.saxVersion = 2;
/*  849 */       this.contentHandler.setDocumentLocator(this);
/*      */     } else {
/*      */       
/*  852 */       this.saxVersion = 0;
/*      */     } 
/*      */   }
/*  855 */   public DTDHandler getDTDHandler() { return this.dtdHandler; }
/*  856 */   public EntityResolver getEntityResolver() { return this.lexer.entityManager.getResolver(); } public ErrorHandler getErrorHandler() {
/*  857 */     return this.errorHandler;
/*      */   }
/*      */   
/*      */   public Piccolo() {
/*  861 */     this.fNamespaces = true; this.fNamespacePrefixes = false; this.fResolveDTDURIs = true;
/*  862 */     this.fExternalGeneralEntities = true; this.fExternalParameterEntities = true;
/*  863 */     this.fLexicalParameterEntities = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  983 */     this.oneCharBuffer = new char[1]; } public Piccolo(Piccolo paramPiccolo) { this.fNamespaces = true; this.fNamespacePrefixes = false; this.fResolveDTDURIs = true; this.fExternalGeneralEntities = true; this.fExternalParameterEntities = true; this.fLexicalParameterEntities = true; this.oneCharBuffer = new char[1]; this.fNamespaces = paramPiccolo.fNamespaces; this.fNamespacePrefixes = paramPiccolo.fNamespacePrefixes; this.fExternalGeneralEntities = paramPiccolo.fExternalGeneralEntities; this.fExternalParameterEntities = paramPiccolo.fExternalParameterEntities; this.fLexicalParameterEntities = paramPiccolo.fLexicalParameterEntities; this.lexer.enableNamespaces(this.fNamespaces); this.fResolveDTDURIs = paramPiccolo.fResolveDTDURIs; }
/*      */   public boolean getFeature(String paramString) throws SAXNotSupportedException, SAXNotRecognizedException { if (paramString.equals("http://xml.org/sax/features/namespaces")) return this.fNamespaces;  if (paramString.equals("http://xml.org/sax/features/namespace-prefixes")) return this.fNamespacePrefixes;  if (paramString.equals("http://xml.org/sax/features/external-general-entities")) return this.fExternalGeneralEntities;  if (paramString.equals("http://xml.org/sax/features/external-parameter-entities")) return this.fExternalGeneralEntities;  if (paramString.equals("http://xml.org/sax/features/lexical-handler/parameter-entities")) return this.fLexicalParameterEntities;  if (paramString.equals("http://xml.org/sax/features/string-interning")) return true;  if (paramString.equals("http://xml.org/sax/features/is-standalone")) return this.docEntity.isStandalone();  if (paramString.equals("http://xml.org/sax/features/resolve-dtd-uris")) return this.fResolveDTDURIs;  if (paramString.equals("http://xml.org/sax/features/use-attributes2") || paramString.equals("http://xml.org/sax/features/validation") || paramString.equals("http://xml.org/sax/features/use-locator2") || paramString.equals("http://xml.org/sax/features/use-entity2") || paramString.equals("http://xml.org/sax/features/use-locator2")) return false;  throw new SAXNotRecognizedException(paramString); }
/*  985 */   public void setFeature(String paramString, boolean paramBoolean) throws SAXNotSupportedException, SAXNotRecognizedException { if (paramString.equals("http://xml.org/sax/features/namespaces")) { if (this.parsingInProgress) throw new SAXNotSupportedException("Can't change namespace settings while parsing");  this.fNamespaces = paramBoolean; this.lexer.enableNamespaces(paramBoolean); } else if (paramString.equals("http://xml.org/sax/features/namespace-prefixes")) { if (this.parsingInProgress) throw new SAXNotSupportedException("Can't change namespace settings while parsing");  this.fNamespacePrefixes = paramBoolean; } else if (paramString.equals("http://xml.org/sax/features/external-general-entities")) { this.fExternalGeneralEntities = paramBoolean; } else if (paramString.equals("http://xml.org/sax/features/external-parameter-entities")) { this.fExternalParameterEntities = paramBoolean; } else if (paramString.equals("http://xml.org/sax/features/lexical-handler/parameter-entities")) { this.fLexicalParameterEntities = paramBoolean; } else if (paramString.equals("http://xml.org/sax/features/resolve-dtd-uris")) { this.fResolveDTDURIs = paramBoolean; } else if (paramString.equals("http://xml.org/sax/features/validation")) { if (paramBoolean) throw new SAXNotSupportedException("validation is not supported");  } else if (paramString.equals("http://xml.org/sax/features/string-interning")) { if (!paramBoolean) throw new SAXNotSupportedException("strings are always internalized");  } else if (paramString.equals("http://xml.org/sax/features/use-attributes2") || paramString.equals("http://xml.org/sax/features/validation") || paramString.equals("http://xml.org/sax/features/use-locator2") || paramString.equals("http://xml.org/sax/features/use-entity2") || paramString.equals("http://xml.org/sax/features/use-locator2")) { if (paramBoolean) throw new SAXNotSupportedException(paramString);  } else { throw new SAXNotRecognizedException(paramString); }  } void reportCdata(char paramChar) throws SAXException { this.oneCharBuffer[0] = paramChar;
/*  986 */     reportCdata(this.oneCharBuffer, 0, 1); }
/*      */   public Object getProperty(String paramString) throws SAXNotRecognizedException, SAXNotSupportedException { if (paramString.equals("http://xml.org/sax/properties/declaration-handler")) return this.declHandler;  if (paramString.equals("http://xml.org/sax/properties/lexical-handler"))
/*      */       return this.lexHandler;  throw new SAXNotRecognizedException(paramString); }
/*      */   public void setProperty(String paramString, Object paramObject) throws SAXNotRecognizedException, SAXNotSupportedException { if (paramString.equals("http://xml.org/sax/properties/declaration-handler")) { try { this.declHandler = (DeclHandler)paramObject; } catch (ClassCastException classCastException) { throw new SAXNotSupportedException("property value is not a DeclHandler"); }  } else if (paramString.equals("http://xml.org/sax/properties/lexical-handler")) { try { this.lexHandler = (LexicalHandler)paramObject; } catch (ClassCastException classCastException) { throw new SAXNotSupportedException("property value is not a LexicalHandler"); }  } else { throw new SAXNotRecognizedException(paramString); }  }
/*  990 */   void reportCdata() throws SAXException { reportCdata(this.lexer.cdataBuffer, this.lexer.cdataStart, this.lexer.cdataLength); } void reportCdata(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws SAXException { switch (this.saxVersion) {
/*      */       case 2:
/*  992 */         this.contentHandler.characters(paramArrayOfchar, paramInt1, paramInt2);
/*      */         break;
/*      */       case 1:
/*  995 */         this.documentHandler.characters(paramArrayOfchar, paramInt1, paramInt2);
/*      */         break;
/*      */     }  }
/*      */ 
/*      */ 
/*      */   
/*      */   void reportWhitespace() throws SAXException {
/* 1002 */     reportWhitespace(this.lexer.cdataBuffer, this.lexer.cdataStart, this.lexer.cdataLength);
/*      */   }
/*      */   
/*      */   void reportWhitespace(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws SAXException {
/* 1006 */     switch (this.saxVersion) {
/*      */       case 2:
/* 1008 */         this.contentHandler.characters(paramArrayOfchar, paramInt1, paramInt2);
/*      */         break;
/*      */       case 1:
/* 1011 */         this.documentHandler.characters(paramArrayOfchar, paramInt1, paramInt2);
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   void reportError(String paramString) throws SAXException {
/* 1018 */     if (this.errorHandler != null) {
/* 1019 */       this.errorHandler.error(new SAXParseException(paramString, getPublicId(), getSystemId(), getLineNumber(), getColumnNumber()));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   void reportFatalError(String paramString) throws SAXException {
/* 1025 */     reportFatalError(paramString, null);
/*      */   }
/*      */   
/*      */   void reportFatalError(String paramString, Exception paramException) throws SAXException {
/* 1029 */     if (paramException != null) {
/* 1030 */       StringWriter stringWriter = new StringWriter();
/* 1031 */       paramException.printStackTrace(new PrintWriter(stringWriter));
/* 1032 */       if (paramString != null) {
/* 1033 */         paramString = paramString + "\n" + stringWriter.toString();
/*      */       } else {
/* 1035 */         paramString = stringWriter.toString();
/*      */       } 
/*      */     } 
/* 1038 */     SAXParseException sAXParseException = new SAXParseException(paramString, getPublicId(), getSystemId(), getLineNumber(), getColumnNumber(), paramException);
/*      */ 
/*      */ 
/*      */     
/* 1042 */     if (this.errorHandler != null) {
/* 1043 */       this.errorHandler.fatalError(sAXParseException);
/*      */     } else {
/* 1045 */       throw sAXParseException;
/*      */     } 
/*      */   }
/*      */   
/*      */   void reportSkippedEntity(String paramString) throws SAXException {
/* 1050 */     if (this.saxVersion == 2) {
/* 1051 */       this.contentHandler.skippedEntity(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   void reportPI(String paramString1, String paramString2) throws SAXException {
/* 1057 */     switch (this.saxVersion) {
/*      */       case 2:
/* 1059 */         this.contentHandler.processingInstruction(paramString1, paramString2);
/*      */         break;
/*      */       case 1:
/* 1062 */         this.documentHandler.processingInstruction(paramString1, paramString2);
/*      */         break;
/*      */     } 
/*      */   }
/*      */   
/*      */   void reportUnparsedEntityDecl(String paramString1, String paramString2, String paramString3, String paramString4) throws SAXException {
/* 1068 */     if (this.dtdHandler != null) {
/* 1069 */       this.dtdHandler.unparsedEntityDecl(paramString1, paramString2, resolveSystemID(paramString3), paramString4);
/*      */     }
/*      */   }
/*      */   
/*      */   void reportNotationDecl(String paramString1, String paramString2, String paramString3) throws SAXException {
/* 1074 */     if (this.dtdHandler != null) {
/* 1075 */       this.dtdHandler.notationDecl(paramString1, paramString2, resolveSystemID(paramString3));
/*      */     }
/*      */   }
/*      */   
/*      */   void reportStartTag(String paramString1, String paramString2, String paramString3) throws SAXException {
/* 1080 */     switch (this.saxVersion) {
/*      */       case 2:
/* 1082 */         this.contentHandler.startElement(paramString1, paramString2, paramString3, this.lexer.attribs);
/*      */         break;
/*      */       case 1:
/* 1085 */         this.documentHandler.startElement(paramString3, this.lexer.attribs);
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   void reportEndTag(String paramString1, String paramString2, String paramString3) throws SAXException {
/* 1092 */     switch (this.saxVersion) {
/*      */       case 2:
/* 1094 */         this.contentHandler.endElement(paramString1, paramString2, paramString3);
/*      */         break;
/*      */       case 1:
/* 1097 */         this.documentHandler.endElement(paramString3);
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   void reportStartPrefixMapping(String paramString1, String paramString2) throws SAXException {
/* 1104 */     if (this.saxVersion == 2) {
/* 1105 */       this.contentHandler.startPrefixMapping(paramString1, paramString2);
/*      */     }
/*      */   }
/*      */   
/*      */   void reportEndPrefixMapping(String paramString) throws SAXException {
/* 1110 */     if (this.saxVersion == 2) {
/* 1111 */       this.contentHandler.endPrefixMapping(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void reportStartDocument() throws SAXException {
/* 1118 */     this.parsingInProgress = true;
/* 1119 */     switch (this.saxVersion) {
/*      */       case 2:
/* 1121 */         this.contentHandler.startDocument();
/*      */         break;
/*      */       case 1:
/* 1124 */         this.documentHandler.startDocument();
/*      */         break;
/*      */     } 
/*      */   }
/*      */   
/*      */   void reportEndDocument() throws SAXException {
/* 1130 */     this.parsingInProgress = false;
/* 1131 */     switch (this.saxVersion) {
/*      */       case 2:
/* 1133 */         this.contentHandler.endDocument();
/*      */         break;
/*      */       case 1:
/* 1136 */         this.documentHandler.endDocument();
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void reportStartDTD(String paramString1, String paramString2, String paramString3) throws SAXException {
/* 1149 */     if (this.lexHandler != null) {
/* 1150 */       this.lexHandler.startDTD(paramString1, paramString2, paramString3);
/*      */     }
/*      */   }
/*      */   
/*      */   void reportEndDTD() throws SAXException {
/* 1155 */     if (this.lexHandler != null) {
/* 1156 */       this.lexHandler.endDTD();
/*      */     }
/*      */   }
/*      */   
/*      */   void reportStartEntity(String paramString) throws SAXException {
/* 1161 */     if (this.lexHandler != null && (
/* 1162 */       this.fLexicalParameterEntities || paramString.charAt(0) != '%')) {
/* 1163 */       this.lexHandler.startEntity(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   void reportEndEntity(String paramString) throws SAXException {
/* 1169 */     if (this.lexHandler != null && (
/* 1170 */       this.fLexicalParameterEntities || paramString.charAt(0) != '%')) {
/* 1171 */       this.lexHandler.endEntity(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   void reportStartCdata() throws SAXException {
/* 1177 */     if (this.lexHandler != null) {
/* 1178 */       this.lexHandler.startCDATA();
/*      */     }
/*      */   }
/*      */   
/*      */   void reportEndCdata() throws SAXException {
/* 1183 */     if (this.lexHandler != null) {
/* 1184 */       this.lexHandler.endCDATA();
/*      */     }
/*      */   }
/*      */   
/*      */   void reportComment(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws SAXException {
/* 1189 */     if (this.lexHandler != null) {
/* 1190 */       this.lexHandler.comment(paramArrayOfchar, paramInt1, paramInt2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void addAttributeDefinition(String paramString1, int paramInt1, int paramInt2, String paramString2) throws SAXException, IOException {
/* 1200 */     String str1 = "", str2 = "";
/* 1201 */     if (this.fNamespaces) {
/* 1202 */       str2 = paramString1;
/* 1203 */       if (paramString1 == "xmlns" && paramString2 != null) {
/* 1204 */         paramString2.intern();
/*      */       }
/*      */     } 
/* 1207 */     saveAttributeDefinition(str1, str2, paramString1, paramInt1, paramInt2, paramString2);
/*      */   }
/*      */ 
/*      */   
/*      */   private void addPrefixedAttributeDefinition(String paramString1, int paramInt1, int paramInt2, String paramString2) throws SAXException, IOException {
/*      */     String str1, str2;
/* 1213 */     if (this.fNamespaces) {
/* 1214 */       int i = paramString1.indexOf(':');
/* 1215 */       int j = paramString1.length();
/* 1216 */       paramString1.getChars(0, j, this.lexer.cbuf, 0);
/* 1217 */       str1 = this.lexer.stringConverter.convert(this.lexer.cbuf, 0, i);
/* 1218 */       str2 = this.lexer.stringConverter.convert(this.lexer.cbuf, i + 1, j - i + 1);
/*      */     } else {
/*      */       
/* 1221 */       str1 = str2 = "";
/*      */     } 
/*      */     
/* 1224 */     saveAttributeDefinition(str1, str2, paramString1, paramInt1, paramInt2, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void saveAttributeDefinition(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4) throws SAXException, IOException {
/*      */     try {
/* 1231 */       if (paramString4 != null) {
/* 1232 */         if (paramInt1 == 9 || paramInt1 == 10) {
/* 1233 */           paramString4 = this.lexer.normalizeValue(paramString4);
/*      */         }
/* 1235 */         paramString4 = this.lexer.rescanAttributeValue(paramString4);
/*      */       } 
/*      */       
/* 1238 */       if (this.declHandler != null) {
/* 1239 */         String str = null;
/* 1240 */         if (paramInt1 == 2) {
/* 1241 */           this.modelBuffer.insert(0, "NOTATION (");
/* 1242 */           this.modelBuffer.append(')');
/* 1243 */           str = this.modelBuffer.toString();
/*      */         
/*      */         }
/* 1246 */         else if (paramInt1 == 1) {
/* 1247 */           this.modelBuffer.insert(0, '(');
/* 1248 */           this.modelBuffer.append(')');
/* 1249 */           str = this.modelBuffer.toString();
/*      */         } else {
/*      */           
/* 1252 */           str = AttributeDefinition.getValueTypeString(paramInt1);
/*      */         } 
/* 1254 */         this.declHandler.attributeDecl(this.elementDefinition.getName(), paramString3, str, AttributeDefinition.getDefaultTypeString(paramInt2), paramString4);
/*      */ 
/*      */ 
/*      */         
/* 1258 */         this.modelBuffer.setLength(0);
/*      */       } 
/*      */ 
/*      */       
/* 1262 */       this.elementDefinition.addAttribute(new AttributeDefinition(paramString1, paramString2, paramString3, paramInt1, null, paramInt2, paramString4));
/*      */ 
/*      */     
/*      */     }
/* 1266 */     catch (DuplicateKeyException duplicateKeyException) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String resolveSystemID(String paramString) {
/* 1273 */     if (this.fResolveDTDURIs) {
/*      */       try {
/* 1275 */         return EntityManager.resolveSystemID(this.docEntity.getSystemID(), paramString);
/*      */       }
/* 1277 */       catch (MalformedURLException malformedURLException) {
/* 1278 */         return paramString;
/*      */       } 
/*      */     }
/*      */     
/* 1282 */     return paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int yylex() throws IOException, SAXException {
/*      */     try {
/* 1290 */       int i = this.lexer.yylex();
/* 1291 */       this.yylval = this.lexer.stringValue;
/* 1292 */       this.lexer.stringValue = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1305 */       return i;
/*      */     }
/* 1307 */     catch (IOException iOException) {
/* 1308 */       while (this.lexer.currentEntity == null && this.lexer.entityStack.size() > 0) {
/* 1309 */         this.lexer.currentEntity = this.lexer.entityStack.pop();
/*      */         try {
/* 1311 */           if (this.lexer.yymoreStreams()) {
/* 1312 */             this.lexer.yypopStream();
/*      */           }
/* 1314 */         } catch (IOException iOException1) {}
/*      */       } 
/*      */       
/* 1317 */       throw iOException;
/*      */     }
/* 1319 */     catch (SAXException sAXException) {
/* 1320 */       while (this.lexer.currentEntity == null && this.lexer.entityStack.size() > 0) {
/* 1321 */         this.lexer.currentEntity = this.lexer.entityStack.pop();
/*      */         try {
/* 1323 */           if (this.lexer.yymoreStreams()) {
/* 1324 */             this.lexer.yypopStream();
/*      */           }
/* 1326 */         } catch (IOException iOException) {}
/*      */       } 
/*      */       
/* 1329 */       throw sAXException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void yyerror(String paramString) throws SAXException {
/* 1338 */     if (this.yychar <= 0) {
/* 1339 */       throw new FatalParsingException("Unexpected end of file after " + this.yylval);
/*      */     }
/* 1341 */     throw new FatalParsingException("Unexpected element: " + yyname[this.yychar]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void yylexdebug(int paramInt1, int paramInt2) {
/* 1357 */     String str = null;
/* 1358 */     if (paramInt2 < 0) paramInt2 = 0; 
/* 1359 */     if (paramInt2 <= 317)
/* 1360 */       str = yyname[paramInt2]; 
/* 1361 */     if (str == null)
/* 1362 */       str = "illegal-symbol"; 
/* 1363 */     debug("state " + paramInt1 + ", reading " + paramInt2 + " (" + str + ")");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int yyparse() throws SAXException, IOException {
/* 1384 */     init_stacks();
/* 1385 */     this.yynerrs = 0;
/* 1386 */     this.yyerrflag = 0;
/* 1387 */     this.yychar = -1;
/* 1388 */     this.yystate = 0;
/* 1389 */     state_push(this.yystate);
/*      */     
/*      */     while (true) {
/* 1392 */       boolean bool = true;
/*      */ 
/*      */       
/* 1395 */       for (this.yyn = yydefred[this.yystate]; this.yyn == 0; this.yyn = yydefred[this.yystate]) {
/*      */ 
/*      */         
/* 1398 */         if (this.yychar < 0)
/*      */         {
/* 1400 */           this.yychar = yylex();
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1410 */         this.yyn = yysindex[this.yystate];
/* 1411 */         if (this.yyn != 0 && (this.yyn += this.yychar) >= 0 && this.yyn <= 508 && yycheck[this.yyn] == this.yychar) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1417 */           this.yystate = yytable[this.yyn];
/* 1418 */           state_push(this.yystate);
/* 1419 */           val_push(this.yylval);
/* 1420 */           this.yychar = -1;
/* 1421 */           if (this.yyerrflag > 0)
/* 1422 */             this.yyerrflag--; 
/* 1423 */           bool = false;
/*      */           
/*      */           break;
/*      */         } 
/* 1427 */         this.yyn = yyrindex[this.yystate];
/* 1428 */         if (this.yyn != 0 && (this.yyn += this.yychar) >= 0 && this.yyn <= 508 && yycheck[this.yyn] == this.yychar) {
/*      */ 
/*      */ 
/*      */           
/* 1432 */           this.yyn = yytable[this.yyn];
/* 1433 */           bool = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */         
/* 1438 */         if (this.yyerrflag == 0) {
/*      */           
/* 1440 */           yyerror("syntax error");
/* 1441 */           this.yynerrs++;
/*      */         } 
/* 1443 */         if (this.yyerrflag < 3) {
/*      */           
/* 1445 */           this.yyerrflag = 3;
/*      */           
/*      */           while (true) {
/* 1448 */             this.yyn = yysindex[state_peek(0)];
/* 1449 */             if (this.yyn != 0 && (this.yyn += 256) >= 0 && this.yyn <= 508 && yycheck[this.yyn] == 256) {
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1454 */               this.yystate = yytable[this.yyn];
/* 1455 */               state_push(this.yystate);
/* 1456 */               val_push(this.yylval);
/* 1457 */               bool = false;
/*      */ 
/*      */               
/*      */               break;
/*      */             } 
/*      */ 
/*      */             
/* 1464 */             state_pop();
/* 1465 */             val_pop();
/*      */           }
/*      */         
/*      */         }
/*      */         else {
/*      */           
/* 1471 */           if (this.yychar == 0) {
/* 1472 */             return 1;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1480 */           this.yychar = -1;
/*      */         } 
/*      */       } 
/*      */       
/* 1484 */       if (!bool)
/*      */         continue; 
/* 1486 */       this.yym = yylen[this.yyn];
/*      */ 
/*      */       
/* 1489 */       if (this.yym > 0)
/* 1490 */         this.yyval = val_peek(this.yym - 1); 
/* 1491 */       switch (this.yyn) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 20:
/* 1497 */           this.dtdName = val_peek(2);
/* 1498 */           this.lexer.yybegin(0);
/* 1499 */           reportStartDTD(this.dtdName, null, null);
/* 1500 */           reportEndDTD();
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 21:
/* 1507 */           this.lexer.yybegin(0);
/* 1508 */           reportEndDTD();
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 22:
/* 1515 */           this.lexer.yybegin(0);
/* 1516 */           reportEndDTD();
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 23:
/* 1523 */           this.lexer.yybegin(0);
/* 1524 */           reportEndDTD();
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 24:
/* 1531 */           this.dtdName = val_peek(4);
/* 1532 */           this.lexer.yybegin(0);
/* 1533 */           reportStartDTD(this.dtdName, this.pubID, this.sysID);
/* 1534 */           reportEndDTD();
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 26:
/* 1541 */           this.lexer.pushEntity("[dtd]", this.dtdPubID, this.dtdSysID, false, true);
/* 1542 */           this.lexer.yybegin(21);
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 27:
/* 1549 */           this.lexer.pushEntity("[dtd]", this.dtdPubID, this.dtdSysID, false, true);
/* 1550 */           this.lexer.yybegin(21);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 28:
/* 1556 */           this.dtdName = this.lexer.normalizeValue(val_peek(5));
/* 1557 */           this.dtdPubID = null;
/* 1558 */           this.dtdSysID = this.lexer.normalizeValue(val_peek(1));
/* 1559 */           reportStartDTD(this.dtdName, this.dtdPubID, this.dtdSysID);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 29:
/* 1565 */           this.dtdName = val_peek(7);
/* 1566 */           this.dtdPubID = this.lexer.normalizeValue(val_peek(3));
/* 1567 */           this.dtdSysID = this.lexer.normalizeValue(val_peek(1));
/* 1568 */           reportStartDTD(this.dtdName, this.dtdPubID, this.dtdSysID);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 30:
/* 1574 */           this.dtdName = val_peek(1);
/* 1575 */           reportStartDTD(this.dtdName, null, null);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 31:
/* 1581 */           this.dtdName = val_peek(1);
/* 1582 */           reportStartDTD(this.dtdName, null, null);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 32:
/* 1588 */           this.dtdName = val_peek(3);
/* 1589 */           reportStartDTD(this.dtdName, this.pubID, this.sysID);
/*      */           break;
/*      */ 
/*      */         
/*      */         case 33:
/* 1594 */           this.pubID = null; this.sysID = this.lexer.normalizeValue(val_peek(0));
/*      */           break;
/*      */ 
/*      */         
/*      */         case 34:
/* 1599 */           this.pubID = this.lexer.normalizeValue(val_peek(2));
/* 1600 */           this.sysID = this.lexer.normalizeValue(val_peek(0));
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 46:
/* 1606 */           this.lexer.yybegin(21);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 47:
/* 1612 */           this.lexer.yybegin(21);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 49:
/* 1618 */           this.lexer.yybegin(28);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 53:
/* 1624 */           this.lexer.entityManager.putInternal(val_peek(4), val_peek(2), 0);
/* 1625 */           if (this.declHandler != null) {
/* 1626 */             this.declHandler.internalEntityDecl(val_peek(4), val_peek(2));
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 54:
/*      */           try {
/* 1633 */             this.lexer.entityManager.putExternal(this.lexer.currentEntity, val_peek(4), this.pubID, this.sysID, 0);
/* 1634 */             if (this.declHandler != null) {
/* 1635 */               this.declHandler.externalEntityDecl(val_peek(4), this.pubID, resolveSystemID(this.sysID));
/*      */             }
/* 1637 */           } catch (MalformedURLException malformedURLException) {
/* 1638 */             reportFatalError("Invalid system identifier: " + this.sysID + "; " + malformedURLException.getMessage());
/*      */           } 
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 55:
/*      */           try {
/* 1647 */             this.lexer.entityManager.putUnparsed(this.lexer.currentEntity, val_peek(8), this.pubID, this.sysID, val_peek(2), 0);
/* 1648 */             reportUnparsedEntityDecl(val_peek(8), this.pubID, this.sysID, val_peek(2));
/*      */           
/*      */           }
/* 1651 */           catch (MalformedURLException malformedURLException) {
/* 1652 */             reportFatalError("Invalid system identifier: " + this.sysID + "; " + malformedURLException.getMessage());
/*      */           } 
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 56:
/* 1660 */           this.lexer.entityManager.putInternal(val_peek(4), val_peek(2), 1);
/* 1661 */           if (this.declHandler != null) {
/* 1662 */             this.declHandler.internalEntityDecl("%" + val_peek(4), val_peek(2));
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 57:
/*      */           try {
/* 1669 */             this.lexer.entityManager.putExternal(this.lexer.currentEntity, val_peek(4), this.pubID, this.sysID, 1);
/* 1670 */             if (this.declHandler != null) {
/* 1671 */               this.declHandler.externalEntityDecl("%" + val_peek(4), this.pubID, resolveSystemID(this.sysID));
/*      */             }
/* 1673 */           } catch (MalformedURLException malformedURLException) {
/* 1674 */             reportFatalError("Invalid system identifier: " + this.sysID + "; " + malformedURLException.getMessage());
/*      */           } 
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 58:
/*      */           try {
/* 1683 */             this.lexer.entityManager.putUnparsed(this.lexer.currentEntity, val_peek(7), this.pubID, this.sysID, val_peek(2), 1);
/* 1684 */             reportUnparsedEntityDecl(val_peek(7), this.pubID, this.sysID, val_peek(2));
/*      */           
/*      */           }
/* 1687 */           catch (MalformedURLException malformedURLException) {
/* 1688 */             reportFatalError("Invalid system identifier: " + this.sysID + "; " + malformedURLException.getMessage());
/*      */           } 
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 59:
/* 1696 */           reportNotationDecl(val_peek(4), this.pubID, this.sysID);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 60:
/* 1702 */           reportNotationDecl(val_peek(6), this.lexer.normalizeValue(val_peek(2)), null);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 61:
/* 1708 */           this.lexer.defineElement(this.elementDefinition.getName(), this.elementDefinition);
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 62:
/* 1715 */           this.elementDefinition = this.lexer.getElement(val_peek(0));
/* 1716 */           if (this.elementDefinition == null) {
/* 1717 */             this.elementDefinition = new ElementDefinition(val_peek(0));
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 65:
/* 1723 */           this.lexer.yybegin(23);
/* 1724 */           addPrefixedAttributeDefinition(val_peek(4), this.attributeType, 2, null);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 66:
/* 1730 */           this.lexer.yybegin(23);
/* 1731 */           addAttributeDefinition(val_peek(4), this.attributeType, 2, null);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 67:
/* 1737 */           this.lexer.yybegin(23);
/* 1738 */           addPrefixedAttributeDefinition(val_peek(4), this.attributeType, 1, null);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 68:
/* 1744 */           this.lexer.yybegin(23);
/* 1745 */           addAttributeDefinition(val_peek(4), this.attributeType, 1, null);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 69:
/* 1751 */           this.lexer.yybegin(23);
/* 1752 */           addPrefixedAttributeDefinition(val_peek(6), this.attributeType, 3, val_peek(0));
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 70:
/* 1758 */           this.lexer.yybegin(23);
/* 1759 */           addAttributeDefinition(val_peek(6), this.attributeType, 3, val_peek(0));
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 71:
/* 1765 */           this.lexer.yybegin(23);
/* 1766 */           addPrefixedAttributeDefinition(val_peek(4), this.attributeType, 0, val_peek(0));
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 72:
/* 1772 */           this.lexer.yybegin(23);
/* 1773 */           addAttributeDefinition(val_peek(4), this.attributeType, 0, val_peek(0));
/*      */           break;
/*      */ 
/*      */         
/*      */         case 73:
/* 1778 */           this.attributeType = 3;
/*      */           break;
/*      */         
/*      */         case 74:
/* 1782 */           this.attributeType = 4;
/*      */           break;
/*      */         
/*      */         case 75:
/* 1786 */           this.attributeType = 5;
/*      */           break;
/*      */         
/*      */         case 76:
/* 1790 */           this.attributeType = 6;
/*      */           break;
/*      */         
/*      */         case 77:
/* 1794 */           this.attributeType = 7;
/*      */           break;
/*      */         
/*      */         case 78:
/* 1798 */           this.attributeType = 8;
/*      */           break;
/*      */         
/*      */         case 79:
/* 1802 */           this.attributeType = 9;
/*      */           break;
/*      */         
/*      */         case 80:
/* 1806 */           this.attributeType = 10;
/*      */           break;
/*      */ 
/*      */         
/*      */         case 81:
/* 1811 */           this.attributeType = 1;
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 82:
/* 1817 */           this.attributeType = 2;
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 83:
/* 1823 */           if (this.declHandler != null) {
/* 1824 */             this.modelBuffer.append(val_peek(0));
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 84:
/* 1830 */           if (this.declHandler != null) {
/* 1831 */             this.modelBuffer.append('|');
/* 1832 */             this.modelBuffer.append(val_peek(0));
/*      */           } 
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 85:
/* 1839 */           if (this.declHandler != null) {
/* 1840 */             this.declHandler.elementDecl(val_peek(4), val_peek(2));
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 86:
/* 1846 */           if (this.declHandler != null) {
/* 1847 */             this.yyval = "EMPTY";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 87:
/* 1853 */           if (this.declHandler != null) {
/* 1854 */             this.yyval = "ANY";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 88:
/* 1860 */           if (this.declHandler != null) {
/* 1861 */             this.yyval = val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 89:
/* 1867 */           if (this.declHandler != null) {
/* 1868 */             this.yyval = val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 90:
/* 1874 */           if (this.declHandler != null) {
/* 1875 */             this.yyval = "(#PCDATA)*";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 91:
/* 1881 */           if (this.declHandler != null) {
/* 1882 */             this.yyval = "(#PCDATA)";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 92:
/* 1888 */           if (this.declHandler != null) {
/* 1889 */             this.yyval = "(#PCDATA|" + this.modelBuffer.toString() + ")*";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 93:
/* 1895 */           if (this.declHandler != null) {
/* 1896 */             this.yyval = val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 94:
/* 1902 */           if (this.declHandler != null) {
/* 1903 */             this.yyval = val_peek(1) + val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 95:
/* 1909 */           if (this.declHandler != null) {
/* 1910 */             this.yyval = val_peek(1) + val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 96:
/* 1916 */           if (this.declHandler != null) {
/* 1917 */             this.yyval = val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 97:
/* 1923 */           if (this.declHandler != null) {
/* 1924 */             this.yyval = val_peek(4) + "|" + val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 98:
/* 1930 */           if (this.declHandler != null) {
/* 1931 */             this.yyval = val_peek(4) + "|" + val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 99:
/* 1937 */           if (this.declHandler != null) {
/* 1938 */             this.yyval = val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 100:
/* 1944 */           if (this.declHandler != null) {
/* 1945 */             this.yyval = val_peek(3) + "," + val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 101:
/* 1951 */           if (this.declHandler != null) {
/* 1952 */             this.yyval = val_peek(2) + val_peek(1);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 102:
/* 1958 */           if (this.declHandler != null) {
/* 1959 */             this.yyval = val_peek(2) + val_peek(1);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 103:
/* 1965 */           if (this.declHandler != null) {
/* 1966 */             this.yyval = val_peek(2) + val_peek(1);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 104:
/* 1972 */           if (this.declHandler != null) {
/* 1973 */             this.yyval = val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 105:
/* 1979 */           if (this.declHandler != null) {
/* 1980 */             this.yyval = "(" + val_peek(2) + ")";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 106:
/* 1986 */           if (this.declHandler != null) {
/* 1987 */             this.yyval = val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 107:
/* 1993 */           if (this.declHandler != null) {
/* 1994 */             this.yyval = "(" + val_peek(2) + ")";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 108:
/* 2000 */           if (this.declHandler != null) {
/* 2001 */             this.yyval = val_peek(0);
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 109:
/* 2007 */           if (this.declHandler != null) {
/* 2008 */             this.yyval = "?";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 110:
/* 2014 */           if (this.declHandler != null) {
/* 2015 */             this.yyval = "*";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 111:
/* 2021 */           if (this.declHandler != null) {
/* 2022 */             this.yyval = "+";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 112:
/* 2028 */           if (this.declHandler != null) {
/* 2029 */             this.yyval = "";
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 114:
/* 2035 */           this.lexer.setTokenize(false);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 115:
/* 2041 */           this.lexer.setTokenize(false);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 116:
/* 2047 */           this.lexer.setTokenize(false);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 121:
/* 2053 */           reportWhitespace();
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2061 */       state_drop(this.yym);
/* 2062 */       this.yystate = state_peek(0);
/* 2063 */       val_drop(this.yym);
/* 2064 */       this.yym = yylhs[this.yyn];
/* 2065 */       if (this.yystate == 0 && this.yym == 0) {
/*      */ 
/*      */         
/* 2068 */         this.yystate = 3;
/* 2069 */         state_push(3);
/* 2070 */         val_push(this.yyval);
/* 2071 */         if (this.yychar < 0)
/*      */         {
/* 2073 */           this.yychar = yylex();
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 2078 */         if (this.yychar == 0) {
/*      */           break;
/*      */         }
/*      */         continue;
/*      */       } 
/* 2083 */       this.yyn = yygindex[this.yym];
/* 2084 */       if (this.yyn != 0 && (this.yyn += this.yystate) >= 0 && this.yyn <= 508 && yycheck[this.yyn] == this.yystate) {
/*      */         
/* 2086 */         this.yystate = yytable[this.yyn];
/*      */       } else {
/* 2088 */         this.yystate = yydgoto[this.yym];
/*      */       } 
/* 2090 */       state_push(this.yystate);
/* 2091 */       val_push(this.yyval);
/*      */     } 
/*      */     
/* 2094 */     return 0;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\Piccolo.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */