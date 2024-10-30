/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class XMLDeclParser
/*     */ {
/*     */   public static final int YYEOF = -1;
/*     */   private static final int YY_BUFFERSIZE = 0;
/*     */   public static final int GOT_ENCODING = 5;
/*     */   public static final int ENCODING = 4;
/*     */   public static final int XML_DECL = 1;
/*     */   public static final int YYINITIAL = 0;
/*     */   public static final int STANDALONE = 6;
/*     */   public static final int GOT_VERSION = 3;
/*     */   public static final int VERSION = 2;
/*     */   public static final int GOT_STANDALONE = 7;
/*     */   private static final String yycmap_packed = "\t\000\001\001\001\001\002\000\001\001\022\000\001\001\001\000\001\022\004\000\001\026\005\000\001 \001\024\001\000\001\025\001\023\003\005\001(\001&\001\005\001!\001)\001\003\001\000\001\006\001\002\001\034\001\007\001\000\001#\001\004\001$\002\004\001\037\002\004\001%\005\004\001'\003\004\001\"\001\036\001\035\005\004\004\000\001\005\001\000\001\033\001\004\001\027\001\030\001\f\001\004\001\031\001\004\001\017\002\004\001\n\001\t\001\021\001\020\002\004\001\r\001\016\001\032\001\004\001\013\001\004\001\b\001*\001\004ﾅ\000";
/*  74 */   private static final char[] yycmap = yy_unpack_cmap("\t\000\001\001\001\001\002\000\001\001\022\000\001\001\001\000\001\022\004\000\001\026\005\000\001 \001\024\001\000\001\025\001\023\003\005\001(\001&\001\005\001!\001)\001\003\001\000\001\006\001\002\001\034\001\007\001\000\001#\001\004\001$\002\004\001\037\002\004\001%\005\004\001'\003\004\001\"\001\036\001\035\005\004\004\000\001\005\001\000\001\033\001\004\001\027\001\030\001\f\001\004\001\031\001\004\001\017\002\004\001\n\001\t\001\021\001\020\002\004\001\r\001\016\001\032\001\004\001\013\001\004\001\b\001*\001\004ﾅ\000");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   private static final int[] yy_rowMap = new int[] { 0, 43, 86, 129, 172, 215, 258, 301, 344, 387, 344, 430, 473, 516, 559, 602, 645, 688, 731, 774, 817, 860, 903, 430, 473, 946, 989, 1032, 344, 1075, 1118, 1161, 1204, 602, 1247, 1290, 1333, 1376, 1419, 1462, 1505, 1548, 731, 1591, 1634, 1677, 1720, 860, 1763, 1806, 1849, 1892, 344, 1935, 1978, 344, 2021, 2064, 2107, 2150, 2193, 2236, 2279, 2322, 2365, 2408, 2451, 2494, 2537, 2580, 2623, 2666, 2709, 2752, 2795, 2838, 2881, 2924, 2967, 3010, 3053, 3096, 344, 3139, 3182, 3225, 3268, 3311, 3354, 344, 3397, 3440, 3483, 3526, 3569, 3612, 3655, 3698, 3741, 3784, 344, 3225, 3827, 3870, 3913, 3956, 344, 3999, 4042, 4085, 4128, 4171, 4214, 4257, 4300, 344, 344, 4343, 4386, 4429, 4472, 4515, 4558, 4601, 4644, 4687, 4730, 4773, 4816, 4859, 4902, 4945, 4988, 5031, 5074, 5117, 5160, 344 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String yy_packed0 = "\006\t\001\n$\t\001\013\001\f\005\013\001\r5\013\001\016\003\013\001\017\025\013\001\020\005\013\001\r5\013\001\021\003\013\001\022\025\013\001\023\005\013\001\r5\013\001\024\003\013\001\025\025\013\001\026\005\013\001\r#\0132\000\001\027$\000\001\030\005\000\001\031\003\000\001\032\001\033\001\000\001\0348\000\001\035\021\000\003\036\002\000\n\036\001\000\001\037\002\036\001\000\005\036\001\000\016\036\003\000\003 \002\000\n \001\000\001!\002 \001\000\005 \001\000\016 \001\000\001\"\005\000\001\031\004\000\001\033\001\000\001\034 \000\001#\003\000\n#\005\000\005#\001\000\001$\002#\002\000\001#\001%\001#\001&\001\000\001#\002\000\001#\004\000\001'\003\000\n'\005\000\005'\001\000\001(\002'\002\000\001'\001)\001'\001*\001\000\001'\002\000\001'\001\000\001+\005\000\001\031\006\000\001\034-\000\001,\030\000\001-\021\000\001.\030\000\001/\001\000\0010\005\000\001\031+\000\0011.\000\0012/\000\00133\000\0014\023\000\003\036\002\000\n\036\0015\003\036\001\000\005\036\001\000\016\036\003\000\003\036\002\000\n\036\0015\001\036\0016\001\036\001\000\005\036\001\000\016\036\003\000\003 \002\000\n \001\000\003 \0015\005 \001\000\016 \003\000\003 \002\000\n \001\000\001 \0017\001 \0015\005 \001\000\016 \004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\016#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\001#\0019\003#\001:\b#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\005#\001;\b#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\005#\001<\b#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\016'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\001'\001=\003'\001>\b'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\005'\001?\b'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\005'\001@\b'\020\000\001A&\000\001B.\000\001C&\000\001D'\000\001E.\000\001F4\000\001G.\000\001H\022\000\003\036\002\000\n\036\0015\002\036\001I\001\000\005\036\001\000\016\036\003\000\003 \002\000\n \001\000\002 \001J\0015\005 \001\000\016 \004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\002#\001K\013#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\003#\001L\n#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\007#\001M\006#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\n#\001N\003#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\002'\001O\013'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\003'\001P\n'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\007'\001Q\006'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\n'\001R\003'\022\000\001S&\000\001T2\000\001S\"\000\001U&\000\001V.\000\001W,\000\001X+\000\001Y\034\000\003\036\002\000\n\036\001Z\003\036\001\000\005\036\001\000\016\036\003\000\003 \002\000\n \001\000\003 \001Z\005 \001\000\016 \004\000\002#\002\000\n#\0018\001[\002#\001\000\005#\001\000\003#\001\\\001]\t#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\006#\001%\007#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\b#\001^\005#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\003#\001_\n#\004\000\002'\002\000\n'\001\000\001`\002'\0018\005'\001\000\003'\001a\001b\t'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\006'\001)\007'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\b'\001c\005'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\003'\001d\n'\022\000\001e.\000\001e\025\000\001f8\000\001g3\000\001h*\000\001i\026\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\t#\001j\004#\004\000\002#\002\000\n#\0018\001[\002#\001\000\005#\001\000\004#\001]\t#\004\000\002#\002\000\n#\001k\003#\001\000\005#\001\000\016#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\b#\001l\005#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\004#\001m\t#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\t'\001n\004'\004\000\002'\002\000\n'\001\000\001`\002'\0018\005'\001\000\004'\001b\t'\004\000\002'\002\000\n'\001\000\003'\001k\005'\001\000\016'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\b'\001o\005'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\004'\001p\t'\020\000\001q)\000\001r6\000\001s\023\000\002#\002\000\n#\001t\003#\001\000\005#\001\000\016#\004\000\002#\002\000\n#\001u\003#\001\000\005#\001\000\016#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\004#\001v\t#\004\000\002'\002\000\n'\001\000\003'\001t\005'\001\000\016'\004\000\002'\002\000\n'\001\000\003'\001u\005'\001\000\016'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\004'\001w\t'\021\000\001x*\000\001y#\000\001z$\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\013#\001{\002#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\013'\001|\002'\001\000\001x\001}A\000\001~!\000\001\036\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\f#\001\001#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\f'\001\001'\001\000\001}*\000\001~\0019\000\001\035\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\003#\001\n#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\003'\001\n'\001\000\0015\000\001\"\000\002#\002\000\n#\0018\001\002#\001\000\005#\001\000\016#\004\000\002'\002\000\n'\001\000\001\002'\0018\005'\001\000\016'\001\000\001\001,\000\002#\002\000\n#\001\003#\001\000\005#\001\000\016#\004\000\002'\002\000\n'\001\000\003'\001\005'\001\000\016'\001\000\001)\000";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 216 */   private static final int[] yytrans = yy_unpack();
/*     */   
/*     */   private static final int YY_UNKNOWN_ERROR = 0;
/*     */   
/*     */   private static final int YY_ILLEGAL_STATE = 1;
/*     */   
/*     */   private static final int YY_NO_MATCH = 2;
/*     */   
/*     */   private static final int YY_PUSHBACK_2BIG = 3;
/*     */   
/*     */   private static final int YY_SKIP_2BIG = 4;
/* 227 */   private static final String[] YY_ERROR_MSG = new String[] { "Unkown internal scanner error", "Internal error: unknown state", "Error: could not match input", "Error: pushback value was too large", "Error: skip value was too large" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 238 */   private static final byte[] YY_ATTRIBUTE = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 2, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 5, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 9, 9, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 9 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Reader yy_reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int yy_state;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 257 */   private int yy_lexical_state = 0;
/*     */ 
/*     */ 
/*     */   
/* 261 */   private char[] yy_buffer = new char[0];
/*     */ 
/*     */ 
/*     */   
/* 265 */   private char[] yy_saved_buffer = null;
/*     */ 
/*     */ 
/*     */   
/*     */   private int yy_markedPos;
/*     */ 
/*     */ 
/*     */   
/*     */   private int yy_pushbackPos;
/*     */ 
/*     */ 
/*     */   
/*     */   private int yy_currentPos;
/*     */ 
/*     */ 
/*     */   
/*     */   private int yy_startRead;
/*     */ 
/*     */ 
/*     */   
/*     */   private int yy_endRead;
/*     */ 
/*     */   
/*     */   private int yyline;
/*     */ 
/*     */   
/*     */   private int yychar;
/*     */ 
/*     */   
/*     */   private int yycolumn;
/*     */ 
/*     */   
/*     */   private boolean yy_atBOL = true;
/*     */ 
/*     */   
/*     */   private boolean yy_atEOF;
/*     */ 
/*     */   
/*     */   public static final int SUCCESS = 1;
/*     */ 
/*     */   
/*     */   public static final int NO_DECLARATION = -1;
/*     */ 
/*     */   
/* 309 */   private String xmlVersion = null;
/* 310 */   private String xmlEncoding = null; private boolean xmlStandalone = false; private boolean xmlStandaloneDeclared = false; private int yy_currentPos_l; private int yy_startRead_l;
/*     */   private int yy_markedPos_l;
/*     */   private int yy_endRead_l;
/*     */   private char[] yy_buffer_l;
/*     */   private char[] yycmap_l;
/*     */   private boolean yy_sawCR;
/*     */   private boolean yy_prev_sawCR;
/*     */   private int yyline_next;
/*     */   private int yycolumn_next;
/*     */   
/*     */   public void reset(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 321 */     this.xmlVersion = this.xmlEncoding = null;
/* 322 */     this.xmlStandaloneDeclared = this.xmlStandalone = false;
/* 323 */     yyreset(paramArrayOfchar, paramInt1, paramInt2);
/*     */   }
/*     */   
/* 326 */   public String getXMLVersion() { return this.xmlVersion; }
/* 327 */   public String getXMLEncoding() { return this.xmlEncoding; }
/* 328 */   public boolean isXMLStandaloneDeclared() { return this.xmlStandaloneDeclared; }
/* 329 */   public boolean isXMLStandalone() { return this.xmlStandalone; } public int getCharsRead() {
/* 330 */     return this.yychar + yylength();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   XMLDeclParser(InputStream paramInputStream) {
/* 351 */     this(new InputStreamReader(paramInputStream));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] yy_unpack() {
/* 360 */     int[] arrayOfInt = new int[5203];
/* 361 */     int i = 0;
/* 362 */     i = yy_unpack("\006\t\001\n$\t\001\013\001\f\005\013\001\r5\013\001\016\003\013\001\017\025\013\001\020\005\013\001\r5\013\001\021\003\013\001\022\025\013\001\023\005\013\001\r5\013\001\024\003\013\001\025\025\013\001\026\005\013\001\r#\0132\000\001\027$\000\001\030\005\000\001\031\003\000\001\032\001\033\001\000\001\0348\000\001\035\021\000\003\036\002\000\n\036\001\000\001\037\002\036\001\000\005\036\001\000\016\036\003\000\003 \002\000\n \001\000\001!\002 \001\000\005 \001\000\016 \001\000\001\"\005\000\001\031\004\000\001\033\001\000\001\034 \000\001#\003\000\n#\005\000\005#\001\000\001$\002#\002\000\001#\001%\001#\001&\001\000\001#\002\000\001#\004\000\001'\003\000\n'\005\000\005'\001\000\001(\002'\002\000\001'\001)\001'\001*\001\000\001'\002\000\001'\001\000\001+\005\000\001\031\006\000\001\034-\000\001,\030\000\001-\021\000\001.\030\000\001/\001\000\0010\005\000\001\031+\000\0011.\000\0012/\000\00133\000\0014\023\000\003\036\002\000\n\036\0015\003\036\001\000\005\036\001\000\016\036\003\000\003\036\002\000\n\036\0015\001\036\0016\001\036\001\000\005\036\001\000\016\036\003\000\003 \002\000\n \001\000\003 \0015\005 \001\000\016 \003\000\003 \002\000\n \001\000\001 \0017\001 \0015\005 \001\000\016 \004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\016#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\001#\0019\003#\001:\b#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\005#\001;\b#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\005#\001<\b#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\016'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\001'\001=\003'\001>\b'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\005'\001?\b'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\005'\001@\b'\020\000\001A&\000\001B.\000\001C&\000\001D'\000\001E.\000\001F4\000\001G.\000\001H\022\000\003\036\002\000\n\036\0015\002\036\001I\001\000\005\036\001\000\016\036\003\000\003 \002\000\n \001\000\002 \001J\0015\005 \001\000\016 \004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\002#\001K\013#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\003#\001L\n#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\007#\001M\006#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\n#\001N\003#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\002'\001O\013'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\003'\001P\n'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\007'\001Q\006'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\n'\001R\003'\022\000\001S&\000\001T2\000\001S\"\000\001U&\000\001V.\000\001W,\000\001X+\000\001Y\034\000\003\036\002\000\n\036\001Z\003\036\001\000\005\036\001\000\016\036\003\000\003 \002\000\n \001\000\003 \001Z\005 \001\000\016 \004\000\002#\002\000\n#\0018\001[\002#\001\000\005#\001\000\003#\001\\\001]\t#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\006#\001%\007#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\b#\001^\005#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\003#\001_\n#\004\000\002'\002\000\n'\001\000\001`\002'\0018\005'\001\000\003'\001a\001b\t'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\006'\001)\007'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\b'\001c\005'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\003'\001d\n'\022\000\001e.\000\001e\025\000\001f8\000\001g3\000\001h*\000\001i\026\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\t#\001j\004#\004\000\002#\002\000\n#\0018\001[\002#\001\000\005#\001\000\004#\001]\t#\004\000\002#\002\000\n#\001k\003#\001\000\005#\001\000\016#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\b#\001l\005#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\004#\001m\t#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\t'\001n\004'\004\000\002'\002\000\n'\001\000\001`\002'\0018\005'\001\000\004'\001b\t'\004\000\002'\002\000\n'\001\000\003'\001k\005'\001\000\016'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\b'\001o\005'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\004'\001p\t'\020\000\001q)\000\001r6\000\001s\023\000\002#\002\000\n#\001t\003#\001\000\005#\001\000\016#\004\000\002#\002\000\n#\001u\003#\001\000\005#\001\000\016#\004\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\004#\001v\t#\004\000\002'\002\000\n'\001\000\003'\001t\005'\001\000\016'\004\000\002'\002\000\n'\001\000\003'\001u\005'\001\000\016'\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\004'\001w\t'\021\000\001x*\000\001y#\000\001z$\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\013#\001{\002#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\013'\001|\002'\001\000\001x\001}A\000\001~!\000\001\036\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\f#\001\001#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\f'\001\001'\001\000\001}*\000\001~\0019\000\001\035\000\002#\002\000\n#\0018\003#\001\000\005#\001\000\003#\001\n#\004\000\002'\002\000\n'\001\000\003'\0018\005'\001\000\003'\001\n'\001\000\0015\000\001\"\000\002#\002\000\n#\0018\001\002#\001\000\005#\001\000\016#\004\000\002'\002\000\n'\001\000\001\002'\0018\005'\001\000\016'\001\000\001\001,\000\002#\002\000\n#\001\003#\001\000\005#\001\000\016#\004\000\002'\002\000\n'\001\000\003'\001\005'\001\000\016'\001\000\001)\000", i, arrayOfInt);
/* 363 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int yy_unpack(String paramString, int paramInt, int[] paramArrayOfint) {
/* 373 */     byte b = 0;
/* 374 */     int i = paramInt;
/* 375 */     int j = paramString.length();
/* 376 */     label10: while (b < j) {
/* 377 */       char c1 = paramString.charAt(b++);
/* 378 */       char c2 = paramString.charAt(b++);
/* 379 */       c2--; while (true)
/* 380 */       { paramArrayOfint[i++] = c2; if (--c1 <= '\000')
/*     */           continue label10;  } 
/* 382 */     }  return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static char[] yy_unpack_cmap(String paramString) {
/* 392 */     char[] arrayOfChar = new char[65536];
/* 393 */     byte b1 = 0;
/* 394 */     byte b2 = 0;
/* 395 */     label10: while (b1 < '') {
/* 396 */       char c1 = paramString.charAt(b1++);
/* 397 */       char c2 = paramString.charAt(b1++); while (true)
/* 398 */       { arrayOfChar[b2++] = c2; if (--c1 <= '\000')
/*     */           continue label10;  } 
/* 400 */     }  return arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean yy_refill() throws IOException {
/* 414 */     if (this.yy_startRead > 0) {
/* 415 */       System.arraycopy(this.yy_buffer, this.yy_startRead, this.yy_buffer, 0, this.yy_endRead - this.yy_startRead);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 420 */       this.yy_endRead -= this.yy_startRead;
/* 421 */       this.yy_currentPos -= this.yy_startRead;
/* 422 */       this.yy_markedPos -= this.yy_startRead;
/* 423 */       this.yy_pushbackPos -= this.yy_startRead;
/* 424 */       this.yy_startRead = 0;
/*     */     } 
/*     */ 
/*     */     
/* 428 */     if (this.yy_markedPos >= this.yy_buffer.length || this.yy_currentPos >= this.yy_buffer.length) {
/*     */       
/* 430 */       char[] arrayOfChar = new char[this.yy_buffer.length * 2];
/* 431 */       System.arraycopy(this.yy_buffer, 0, arrayOfChar, 0, this.yy_buffer.length);
/* 432 */       this.yy_buffer = arrayOfChar;
/*     */     } 
/*     */ 
/*     */     
/* 436 */     int i = this.yy_reader.read(this.yy_buffer, this.yy_endRead, this.yy_buffer.length - this.yy_endRead);
/*     */ 
/*     */     
/* 439 */     if (i < 0) {
/* 440 */       return true;
/*     */     }
/*     */     
/* 443 */     this.yy_endRead += i;
/* 444 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void yyclose() throws IOException {
/* 452 */     this.yy_atEOF = true;
/* 453 */     this.yy_endRead = this.yy_startRead;
/*     */     
/* 455 */     if (this.yy_reader != null) {
/* 456 */       this.yy_reader.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void yyreset(Reader paramReader) throws IOException {
/* 473 */     yyclose();
/*     */     
/* 475 */     if (this.yy_saved_buffer != null) {
/* 476 */       this.yy_buffer = this.yy_saved_buffer;
/* 477 */       this.yy_saved_buffer = null;
/*     */     } 
/*     */     
/* 480 */     this.yy_reader = paramReader;
/* 481 */     this.yy_atBOL = true;
/* 482 */     this.yy_atEOF = false;
/* 483 */     this.yy_endRead = this.yy_startRead = 0;
/* 484 */     this.yy_currentPos = this.yy_markedPos = this.yy_pushbackPos = 0;
/*     */     
/* 486 */     this.yyline = this.yychar = this.yycolumn = 0;
/* 487 */     this.yy_state = this.yy_lexical_state = 0;
/* 488 */     this.yy_sawCR = false;
/* 489 */     this.yyline_next = this.yycolumn_next = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void yyreset(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 494 */     yyclose();
/* 495 */     if (this.yy_saved_buffer == null)
/* 496 */       this.yy_saved_buffer = this.yy_buffer; 
/* 497 */     this.yy_buffer = paramArrayOfchar;
/* 498 */     this.yy_reader = null;
/* 499 */     this.yy_atBOL = true;
/* 500 */     this.yy_atEOF = true;
/* 501 */     this.yy_currentPos = this.yy_markedPos = this.yy_pushbackPos = this.yy_startRead = paramInt1;
/*     */     
/* 503 */     this.yy_endRead = paramInt1 + paramInt2;
/* 504 */     this.yyline = this.yychar = this.yycolumn = 0;
/* 505 */     this.yy_state = this.yy_lexical_state = 0;
/* 506 */     this.yy_sawCR = false;
/* 507 */     this.yyline_next = this.yycolumn_next = 0;
/*     */     
/* 509 */     this.yy_endRead_l = this.yy_endRead;
/* 510 */     this.yy_buffer_l = this.yy_buffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int yystate() {
/* 518 */     return this.yy_lexical_state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void yybegin(int paramInt) {
/* 528 */     this.yy_lexical_state = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String yytext() {
/* 536 */     return new String(this.yy_buffer, this.yy_startRead, this.yy_markedPos - this.yy_startRead);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String yytext(int paramInt1, int paramInt2) {
/* 546 */     return new String(this.yy_buffer, this.yy_startRead + paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void yynextAction() {
/* 558 */     this.yyline = this.yyline_next;
/* 559 */     this.yycolumn = this.yycolumn_next;
/*     */     
/* 561 */     this.yy_currentPos = this.yy_startRead = this.yy_markedPos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int yynextChar() throws IOException {
/*     */     char c;
/* 572 */     if (this.yy_markedPos < this.yy_endRead)
/* 573 */     { c = this.yy_buffer[this.yy_markedPos++]; }
/* 574 */     else { if (this.yy_atEOF) {
/* 575 */         return -1;
/*     */       }
/*     */       
/* 578 */       boolean bool = yy_refill();
/* 579 */       this.yy_buffer_l = this.yy_buffer;
/* 580 */       this.yy_endRead_l = this.yy_endRead;
/* 581 */       if (bool) {
/* 582 */         return -1;
/*     */       }
/* 584 */       c = this.yy_buffer[this.yy_markedPos++]; }
/*     */ 
/*     */     
/* 587 */     yy_doCount(c);
/* 588 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int yynextBufferChar() throws IOException {
/* 602 */     char c = this.yy_buffer[this.yy_markedPos++];
/* 603 */     yy_doCount(c);
/* 604 */     return c;
/*     */   }
/*     */   
/*     */   private final int yy_doCount(int paramInt) {
/* 608 */     switch (paramInt)
/*     */     
/*     */     { case 13:
/* 611 */         this.yyline_next++;
/* 612 */         this.yycolumn_next = 0;
/* 613 */         this.yy_sawCR = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 630 */         return paramInt;case 10: if (this.yy_sawCR) { this.yy_sawCR = false; } else { this.yyline_next++; this.yycolumn_next = 0; }  return paramInt; }  this.yy_sawCR = false; this.yycolumn_next++; return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final char yycharat(int paramInt) {
/* 646 */     return this.yy_buffer[this.yy_startRead + paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int yybufferLeft() {
/* 656 */     return this.yy_endRead - this.yy_markedPos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void yyskip(int paramInt) {
/* 667 */     this.yy_markedPos += paramInt;
/* 668 */     this.yy_markedPos_l = this.yy_markedPos;
/* 669 */     if (this.yy_markedPos > this.yy_endRead) {
/* 670 */       yy_ScanError(4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int yylength() {
/* 678 */     return this.yy_markedPos - this.yy_startRead;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void yy_ScanError(int paramInt) {
/*     */     String str;
/*     */     try {
/* 699 */       str = YY_ERROR_MSG[paramInt];
/*     */     }
/* 701 */     catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 702 */       str = YY_ERROR_MSG[0];
/*     */     } 
/*     */     
/* 705 */     throw new Error(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void yypushback(int paramInt) {
/* 718 */     if (paramInt > yylength()) {
/* 719 */       yy_ScanError(3);
/*     */     }
/* 721 */     this.yy_markedPos -= paramInt;
/*     */ 
/*     */     
/* 724 */     this.yyline_next = this.yyline;
/* 725 */     this.yycolumn_next = this.yycolumn;
/* 726 */     this.yy_sawCR = this.yy_prev_sawCR;
/* 727 */     for (int i = this.yy_startRead; i < this.yy_markedPos; i++) {
/* 728 */       yy_doCount(this.yy_buffer[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLDeclParser(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 742 */     this.yy_sawCR = false;
/* 743 */     this.yy_prev_sawCR = false;
/* 744 */     this.yyline_next = 0;
/* 745 */     this.yycolumn_next = 0; yyreset(paramArrayOfchar, paramInt1, paramInt2); } public XMLDeclParser() { this.yy_sawCR = false; this.yy_prev_sawCR = false; this.yyline_next = 0; this.yycolumn_next = 0; } XMLDeclParser(Reader paramReader) { this.yy_sawCR = false; this.yy_prev_sawCR = false; this.yyline_next = 0; this.yycolumn_next = 0;
/*     */     this.yy_reader = paramReader; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int parse() throws IOException, FileFormatException {
/* 760 */     this.yy_endRead_l = this.yy_endRead;
/* 761 */     this.yy_buffer_l = this.yy_buffer;
/* 762 */     this.yycmap_l = yycmap;
/*     */ 
/*     */     
/* 765 */     int[] arrayOfInt1 = yytrans;
/* 766 */     int[] arrayOfInt2 = yy_rowMap;
/* 767 */     byte[] arrayOfByte = YY_ATTRIBUTE;
/* 768 */     int i = this.yy_pushbackPos = -1;
/*     */     
/*     */     while (true) {
/*     */       char c;
/*     */       
/* 773 */       this.yy_markedPos_l = this.yy_markedPos;
/*     */       
/* 775 */       this.yychar += this.yy_markedPos_l - this.yy_startRead;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 783 */       int j = -1;
/*     */       
/* 785 */       this.yy_startRead_l = this.yy_currentPos_l = this.yy_currentPos = this.yy_startRead = this.yy_markedPos_l;
/*     */ 
/*     */       
/* 788 */       this.yy_state = this.yy_lexical_state;
/*     */       
/* 790 */       boolean bool = false;
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/* 795 */         if (this.yy_currentPos_l < this.yy_endRead_l)
/* 796 */         { c = this.yy_buffer_l[this.yy_currentPos_l++]; }
/* 797 */         else { if (this.yy_atEOF) {
/* 798 */             byte b1 = -1;
/*     */             
/*     */             break;
/*     */           } 
/*     */           
/* 803 */           this.yy_currentPos = this.yy_currentPos_l;
/* 804 */           this.yy_markedPos = this.yy_markedPos_l;
/* 805 */           this.yy_pushbackPos = i;
/* 806 */           boolean bool1 = yy_refill();
/*     */           
/* 808 */           this.yy_currentPos_l = this.yy_currentPos;
/* 809 */           this.yy_markedPos_l = this.yy_markedPos;
/* 810 */           this.yy_buffer_l = this.yy_buffer;
/* 811 */           this.yy_endRead_l = this.yy_endRead;
/* 812 */           i = this.yy_pushbackPos;
/* 813 */           if (bool1) {
/* 814 */             byte b1 = -1;
/*     */             
/*     */             break;
/*     */           } 
/* 818 */           c = this.yy_buffer_l[this.yy_currentPos_l++]; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 843 */         int k = arrayOfInt1[arrayOfInt2[this.yy_state] + this.yycmap_l[c]];
/* 844 */         if (k == -1)
/* 845 */           break;  this.yy_state = k;
/*     */         
/* 847 */         byte b = arrayOfByte[this.yy_state];
/* 848 */         if ((b & 0x2) == 2) {
/* 849 */           i = this.yy_currentPos_l;
/*     */         }
/* 851 */         if ((b & 0x1) == 1) {
/* 852 */           bool = ((b & 0x4) == 4) ? true : false;
/* 853 */           j = this.yy_state;
/* 854 */           this.yy_markedPos_l = this.yy_currentPos_l;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 859 */           if ((b & 0x8) == 8) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 866 */       this.yy_markedPos = this.yy_markedPos_l;
/*     */       
/* 868 */       if (bool) {
/* 869 */         this.yy_markedPos = i;
/*     */       }
/* 871 */       switch (j) {
/*     */ 
/*     */         
/*     */         case 115:
/* 875 */           this.xmlEncoding = "UTF-16";
/* 876 */           yybegin(5);
/*     */           continue;
/*     */         case 139:
/*     */           continue;
/*     */         case 106:
/* 881 */           this.xmlEncoding = "UTF-8";
/* 882 */           yybegin(5);
/*     */           continue;
/*     */         case 140:
/*     */           continue;
/*     */         case 89:
/* 887 */           this.xmlVersion = "1.0";
/* 888 */           yybegin(3); continue;
/*     */         case 141:
/*     */           continue;
/*     */         case 101:
/* 892 */           yybegin(1); continue;
/*     */         case 142:
/*     */           continue;
/*     */         case 10:
/*     */         case 11:
/*     */         case 12:
/*     */         case 13:
/*     */         case 14:
/*     */         case 15:
/*     */         case 16:
/*     */         case 17:
/*     */         case 18:
/*     */         case 19:
/*     */         case 20:
/*     */         case 21:
/* 907 */           throw new FileFormatException("XML Declaration not well-formed", -1, -1);
/*     */         
/*     */         case 143:
/*     */           continue;
/*     */         case 82:
/* 912 */           this.xmlStandalone = false; yybegin(7); continue;
/*     */         case 144: continue;
/*     */         case 100:
/* 915 */           this.xmlStandalone = true; yybegin(7); continue;
/*     */         case 145:
/*     */           continue;
/*     */         case 28:
/* 919 */           return 1;
/*     */         case 146:
/*     */           continue;
/*     */         case 8:
/*     */         case 9:
/* 924 */           return -1;
/*     */         case 147:
/*     */           continue;
/*     */         case 124:
/* 928 */           yybegin(2);
/*     */           continue;
/*     */         case 148:
/*     */           continue;
/*     */         case 52:
/* 933 */           this.xmlVersion = yytext(1, yylength() - 2);
/* 934 */           yybegin(3);
/*     */           continue;
/*     */         case 149:
/*     */           continue;
/*     */         case 55:
/* 939 */           this.xmlEncoding = yytext(1, yylength() - 2);
/* 940 */           yybegin(5);
/*     */           continue;
/*     */         case 150:
/*     */           continue;
/*     */         case 129:
/* 945 */           yybegin(4);
/*     */           continue;
/*     */         case 151:
/*     */           continue;
/*     */         case 137:
/* 950 */           this.xmlEncoding = "ISO-8859-1";
/* 951 */           yybegin(5);
/*     */           continue;
/*     */         case 152:
/*     */           continue;
/*     */         case 136:
/* 956 */           this.xmlStandaloneDeclared = true;
/* 957 */           yybegin(6);
/*     */           continue;
/*     */         case 153:
/*     */           continue;
/*     */         case 116:
/* 962 */           this.xmlEncoding = "US-ASCII";
/* 963 */           yybegin(5); continue;
/*     */         case 154:
/*     */           continue;
/*     */       } 
/* 967 */       if (c == -1 && this.yy_startRead == this.yy_currentPos) {
/* 968 */         this.yy_atEOF = true;
/* 969 */         return -1;
/*     */       } 
/*     */       
/* 972 */       yy_ScanError(2);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\XMLDeclParser.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */