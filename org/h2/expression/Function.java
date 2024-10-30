/*      */ package org.h2.expression;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.sql.Connection;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.sql.Timestamp;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Locale;
/*      */ import java.util.TimeZone;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.regex.PatternSyntaxException;
/*      */ import org.h2.command.Command;
/*      */ import org.h2.command.Parser;
/*      */ import org.h2.engine.Constants;
/*      */ import org.h2.engine.Database;
/*      */ import org.h2.engine.Mode;
/*      */ import org.h2.engine.Session;
/*      */ import org.h2.jdbc.JdbcConnection;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.schema.Schema;
/*      */ import org.h2.schema.Sequence;
/*      */ import org.h2.security.BlockCipher;
/*      */ import org.h2.security.CipherFactory;
/*      */ import org.h2.store.fs.FileUtils;
/*      */ import org.h2.table.Column;
/*      */ import org.h2.table.ColumnResolver;
/*      */ import org.h2.table.TableFilter;
/*      */ import org.h2.tools.CompressTool;
/*      */ import org.h2.tools.Csv;
/*      */ import org.h2.util.AutoCloseInputStream;
/*      */ import org.h2.util.DateTimeUtils;
/*      */ import org.h2.util.MathUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.StatementBuilder;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.util.ToDateParser;
/*      */ import org.h2.util.Utils;
/*      */ import org.h2.value.DataType;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueArray;
/*      */ import org.h2.value.ValueBoolean;
/*      */ import org.h2.value.ValueBytes;
/*      */ import org.h2.value.ValueDate;
/*      */ import org.h2.value.ValueDouble;
/*      */ import org.h2.value.ValueInt;
/*      */ import org.h2.value.ValueLong;
/*      */ import org.h2.value.ValueNull;
/*      */ import org.h2.value.ValueResultSet;
/*      */ import org.h2.value.ValueString;
/*      */ import org.h2.value.ValueTime;
/*      */ import org.h2.value.ValueTimestamp;
/*      */ import org.h2.value.ValueUuid;
/*      */ 
/*      */ public class Function extends Expression implements FunctionCall {
/*      */   public static final int ABS = 0;
/*      */   public static final int ACOS = 1;
/*      */   public static final int ASIN = 2;
/*      */   public static final int ATAN = 3;
/*      */   public static final int ATAN2 = 4;
/*      */   public static final int BITAND = 5;
/*      */   public static final int BITOR = 6;
/*      */   public static final int BITXOR = 7;
/*      */   public static final int CEILING = 8;
/*      */   public static final int COS = 9;
/*      */   public static final int COT = 10;
/*      */   public static final int DEGREES = 11;
/*      */   public static final int EXP = 12;
/*      */   public static final int FLOOR = 13;
/*      */   public static final int LOG = 14;
/*      */   public static final int LOG10 = 15;
/*      */   public static final int MOD = 16;
/*      */   public static final int PI = 17;
/*      */   public static final int POWER = 18;
/*      */   public static final int RADIANS = 19;
/*      */   public static final int RAND = 20;
/*      */   public static final int ROUND = 21;
/*      */   public static final int ROUNDMAGIC = 22;
/*      */   public static final int SIGN = 23;
/*      */   public static final int SIN = 24;
/*      */   public static final int SQRT = 25;
/*      */   public static final int TAN = 26;
/*      */   public static final int TRUNCATE = 27;
/*      */   public static final int SECURE_RAND = 28;
/*      */   public static final int HASH = 29;
/*      */   public static final int ENCRYPT = 30;
/*      */   public static final int DECRYPT = 31;
/*      */   public static final int COMPRESS = 32;
/*      */   public static final int EXPAND = 33;
/*      */   public static final int ZERO = 34;
/*      */   public static final int RANDOM_UUID = 35;
/*      */   public static final int COSH = 36;
/*      */   public static final int SINH = 37;
/*      */   public static final int TANH = 38;
/*      */   public static final int LN = 39;
/*      */   public static final int ASCII = 50;
/*      */   public static final int BIT_LENGTH = 51;
/*      */   public static final int CHAR = 52;
/*      */   public static final int CHAR_LENGTH = 53;
/*      */   public static final int CONCAT = 54;
/*      */   public static final int DIFFERENCE = 55;
/*      */   public static final int HEXTORAW = 56;
/*      */   public static final int INSERT = 57;
/*      */   public static final int INSTR = 58;
/*      */   public static final int LCASE = 59;
/*      */   public static final int LEFT = 60;
/*      */   public static final int LENGTH = 61;
/*      */   public static final int LOCATE = 62;
/*      */   public static final int LTRIM = 63;
/*      */   public static final int OCTET_LENGTH = 64;
/*      */   public static final int RAWTOHEX = 65;
/*      */   public static final int REPEAT = 66;
/*      */   public static final int REPLACE = 67;
/*      */   public static final int RIGHT = 68;
/*      */   public static final int RTRIM = 69;
/*      */   public static final int SOUNDEX = 70;
/*      */   public static final int SPACE = 71;
/*      */   public static final int SUBSTR = 72;
/*      */   public static final int SUBSTRING = 73;
/*      */   public static final int UCASE = 74;
/*      */   public static final int LOWER = 75;
/*      */   public static final int UPPER = 76;
/*      */   public static final int POSITION = 77;
/*      */   public static final int TRIM = 78;
/*      */   public static final int STRINGENCODE = 79;
/*      */   public static final int STRINGDECODE = 80;
/*      */   public static final int STRINGTOUTF8 = 81;
/*      */   public static final int UTF8TOSTRING = 82;
/*      */   public static final int XMLATTR = 83;
/*      */   public static final int XMLNODE = 84;
/*      */   public static final int XMLCOMMENT = 85;
/*      */   public static final int XMLCDATA = 86;
/*      */   public static final int XMLSTARTDOC = 87;
/*      */   public static final int XMLTEXT = 88;
/*      */   public static final int REGEXP_REPLACE = 89;
/*      */   public static final int RPAD = 90;
/*  142 */   private static final HashMap<String, FunctionInfo> FUNCTIONS = New.hashMap(); public static final int LPAD = 91; public static final int CONCAT_WS = 92; public static final int TO_CHAR = 93; public static final int TRANSLATE = 94; public static final int ORA_HASH = 95; public static final int TO_DATE = 96; public static final int TO_TIMESTAMP = 97; public static final int ADD_MONTHS = 98; public static final int CURDATE = 100; public static final int CURTIME = 101; public static final int DATE_ADD = 102; public static final int DATE_DIFF = 103; public static final int DAY_NAME = 104; public static final int DAY_OF_MONTH = 105; public static final int DAY_OF_WEEK = 106; public static final int DAY_OF_YEAR = 107; public static final int HOUR = 108; public static final int MINUTE = 109; public static final int MONTH = 110; public static final int MONTH_NAME = 111; public static final int NOW = 112; public static final int QUARTER = 113; public static final int SECOND = 114; public static final int WEEK = 115; public static final int YEAR = 116; public static final int CURRENT_DATE = 117; public static final int CURRENT_TIME = 118; public static final int CURRENT_TIMESTAMP = 119; public static final int EXTRACT = 120; public static final int FORMATDATETIME = 121; public static final int PARSEDATETIME = 122; public static final int ISO_YEAR = 123; public static final int ISO_WEEK = 124; public static final int ISO_DAY_OF_WEEK = 125; public static final int DATABASE = 150; public static final int USER = 151; public static final int CURRENT_USER = 152; public static final int IDENTITY = 153; public static final int SCOPE_IDENTITY = 154; public static final int AUTOCOMMIT = 155; public static final int READONLY = 156; public static final int DATABASE_PATH = 157; public static final int LOCK_TIMEOUT = 158; public static final int DISK_SPACE_USED = 159; public static final int IFNULL = 200; public static final int CASEWHEN = 201; public static final int CONVERT = 202; public static final int CAST = 203; public static final int COALESCE = 204; public static final int NULLIF = 205; public static final int CASE = 206; public static final int NEXTVAL = 207; public static final int CURRVAL = 208; public static final int ARRAY_GET = 209; public static final int CSVREAD = 210; public static final int CSVWRITE = 211; public static final int MEMORY_FREE = 212; public static final int MEMORY_USED = 213; public static final int LOCK_MODE = 214; public static final int SCHEMA = 215; public static final int SESSION_ID = 216; public static final int ARRAY_LENGTH = 217; public static final int LINK_SCHEMA = 218; public static final int GREATEST = 219; public static final int LEAST = 220; public static final int CANCEL_SESSION = 221; public static final int SET = 222; public static final int TABLE = 223; public static final int TABLE_DISTINCT = 224; public static final int FILE_READ = 225; public static final int TRANSACTION_ID = 226; public static final int TRUNCATE_VALUE = 227; public static final int NVL2 = 228; public static final int DECODE = 229; public static final int ARRAY_CONTAINS = 230; public static final int FILE_WRITE = 232; public static final int REGEXP_LIKE = 240; public static final int VALUES = 250; public static final int H2VERSION = 231; public static final int ROW_NUMBER = 300; private static final int VAR_ARGS = -1; private static final long PRECISION_UNKNOWN = -1L;
/*  143 */   private static final HashMap<String, Integer> DATE_PART = New.hashMap();
/*  144 */   private static final char[] SOUNDEX_INDEX = new char[128];
/*      */   
/*      */   protected Expression[] args;
/*      */   private final FunctionInfo info;
/*      */   private ArrayList<Expression> varArgs;
/*      */   private int dataType;
/*      */   private int scale;
/*  151 */   private long precision = -1L;
/*      */   
/*      */   private int displaySize;
/*      */   private final Database database;
/*      */   
/*      */   static {
/*  157 */     DATE_PART.put("SQL_TSI_YEAR", Integer.valueOf(1));
/*  158 */     DATE_PART.put("YEAR", Integer.valueOf(1));
/*  159 */     DATE_PART.put("YYYY", Integer.valueOf(1));
/*  160 */     DATE_PART.put("YY", Integer.valueOf(1));
/*  161 */     DATE_PART.put("SQL_TSI_MONTH", Integer.valueOf(2));
/*  162 */     DATE_PART.put("MONTH", Integer.valueOf(2));
/*  163 */     DATE_PART.put("MM", Integer.valueOf(2));
/*  164 */     DATE_PART.put("M", Integer.valueOf(2));
/*  165 */     DATE_PART.put("SQL_TSI_WEEK", Integer.valueOf(3));
/*  166 */     DATE_PART.put("WW", Integer.valueOf(3));
/*  167 */     DATE_PART.put("WK", Integer.valueOf(3));
/*  168 */     DATE_PART.put("WEEK", Integer.valueOf(3));
/*  169 */     DATE_PART.put("DAY", Integer.valueOf(5));
/*  170 */     DATE_PART.put("DD", Integer.valueOf(5));
/*  171 */     DATE_PART.put("D", Integer.valueOf(5));
/*  172 */     DATE_PART.put("SQL_TSI_DAY", Integer.valueOf(5));
/*  173 */     DATE_PART.put("DAYOFYEAR", Integer.valueOf(6));
/*  174 */     DATE_PART.put("DAY_OF_YEAR", Integer.valueOf(6));
/*  175 */     DATE_PART.put("DY", Integer.valueOf(6));
/*  176 */     DATE_PART.put("DOY", Integer.valueOf(6));
/*  177 */     DATE_PART.put("SQL_TSI_HOUR", Integer.valueOf(11));
/*  178 */     DATE_PART.put("HOUR", Integer.valueOf(11));
/*  179 */     DATE_PART.put("HH", Integer.valueOf(11));
/*  180 */     DATE_PART.put("SQL_TSI_MINUTE", Integer.valueOf(12));
/*  181 */     DATE_PART.put("MINUTE", Integer.valueOf(12));
/*  182 */     DATE_PART.put("MI", Integer.valueOf(12));
/*  183 */     DATE_PART.put("N", Integer.valueOf(12));
/*  184 */     DATE_PART.put("SQL_TSI_SECOND", Integer.valueOf(13));
/*  185 */     DATE_PART.put("SECOND", Integer.valueOf(13));
/*  186 */     DATE_PART.put("SS", Integer.valueOf(13));
/*  187 */     DATE_PART.put("S", Integer.valueOf(13));
/*  188 */     DATE_PART.put("MILLISECOND", Integer.valueOf(14));
/*  189 */     DATE_PART.put("MS", Integer.valueOf(14));
/*      */ 
/*      */     
/*  192 */     String str = "7AEIOUY8HW1BFPV2CGJKQSXZ3DT4L5MN6R";
/*  193 */     char c = Character.MIN_VALUE; byte b; int i;
/*  194 */     for (b = 0, i = str.length(); b < i; b++) {
/*  195 */       char c1 = str.charAt(b);
/*  196 */       if (c1 < '9') {
/*  197 */         c = c1;
/*      */       } else {
/*  199 */         SOUNDEX_INDEX[c1] = c;
/*  200 */         SOUNDEX_INDEX[Character.toLowerCase(c1)] = c;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  205 */     addFunction("ABS", 0, 1, 0);
/*  206 */     addFunction("ACOS", 1, 1, 7);
/*  207 */     addFunction("ASIN", 2, 1, 7);
/*  208 */     addFunction("ATAN", 3, 1, 7);
/*  209 */     addFunction("ATAN2", 4, 2, 7);
/*  210 */     addFunction("BITAND", 5, 2, 5);
/*  211 */     addFunction("BITOR", 6, 2, 5);
/*  212 */     addFunction("BITXOR", 7, 2, 5);
/*  213 */     addFunction("CEILING", 8, 1, 7);
/*  214 */     addFunction("CEIL", 8, 1, 7);
/*  215 */     addFunction("COS", 9, 1, 7);
/*  216 */     addFunction("COSH", 36, 1, 7);
/*  217 */     addFunction("COT", 10, 1, 7);
/*  218 */     addFunction("DEGREES", 11, 1, 7);
/*  219 */     addFunction("EXP", 12, 1, 7);
/*  220 */     addFunction("FLOOR", 13, 1, 7);
/*  221 */     addFunction("LOG", 14, 1, 7);
/*  222 */     addFunction("LN", 39, 1, 7);
/*  223 */     addFunction("LOG10", 15, 1, 7);
/*  224 */     addFunction("MOD", 16, 2, 5);
/*  225 */     addFunction("PI", 17, 0, 7);
/*  226 */     addFunction("POWER", 18, 2, 7);
/*  227 */     addFunction("RADIANS", 19, 1, 7);
/*      */ 
/*      */     
/*  230 */     addFunctionNotDeterministic("RAND", 20, -1, 7);
/*  231 */     addFunctionNotDeterministic("RANDOM", 20, -1, 7);
/*  232 */     addFunction("ROUND", 21, -1, 7);
/*  233 */     addFunction("ROUNDMAGIC", 22, 1, 7);
/*  234 */     addFunction("SIGN", 23, 1, 4);
/*  235 */     addFunction("SIN", 24, 1, 7);
/*  236 */     addFunction("SINH", 37, 1, 7);
/*  237 */     addFunction("SQRT", 25, 1, 7);
/*  238 */     addFunction("TAN", 26, 1, 7);
/*  239 */     addFunction("TANH", 38, 1, 7);
/*  240 */     addFunction("TRUNCATE", 27, -1, 0);
/*      */     
/*  242 */     addFunction("TRUNC", 27, -1, 0);
/*  243 */     addFunction("HASH", 29, 3, 12);
/*  244 */     addFunction("ENCRYPT", 30, 3, 12);
/*  245 */     addFunction("DECRYPT", 31, 3, 12);
/*  246 */     addFunctionNotDeterministic("SECURE_RAND", 28, 1, 12);
/*  247 */     addFunction("COMPRESS", 32, -1, 12);
/*  248 */     addFunction("EXPAND", 33, 1, 12);
/*  249 */     addFunction("ZERO", 34, 0, 4);
/*  250 */     addFunctionNotDeterministic("RANDOM_UUID", 35, 0, 20);
/*  251 */     addFunctionNotDeterministic("SYS_GUID", 35, 0, 20);
/*      */     
/*  253 */     addFunction("ASCII", 50, 1, 4);
/*  254 */     addFunction("BIT_LENGTH", 51, 1, 5);
/*  255 */     addFunction("CHAR", 52, 1, 13);
/*  256 */     addFunction("CHR", 52, 1, 13);
/*  257 */     addFunction("CHAR_LENGTH", 53, 1, 4);
/*      */     
/*  259 */     addFunction("CHARACTER_LENGTH", 53, 1, 4);
/*  260 */     addFunctionWithNull("CONCAT", 54, -1, 13);
/*  261 */     addFunctionWithNull("CONCAT_WS", 92, -1, 13);
/*  262 */     addFunction("DIFFERENCE", 55, 2, 4);
/*  263 */     addFunction("HEXTORAW", 56, 1, 13);
/*  264 */     addFunctionWithNull("INSERT", 57, 4, 13);
/*  265 */     addFunction("LCASE", 59, 1, 13);
/*  266 */     addFunction("LEFT", 60, 2, 13);
/*  267 */     addFunction("LENGTH", 61, 1, 5);
/*      */     
/*  269 */     addFunction("LOCATE", 62, -1, 4);
/*      */     
/*  271 */     addFunction("CHARINDEX", 62, -1, 4);
/*      */     
/*  273 */     addFunction("POSITION", 62, 2, 4);
/*  274 */     addFunction("INSTR", 58, -1, 4);
/*  275 */     addFunction("LTRIM", 63, -1, 13);
/*  276 */     addFunction("OCTET_LENGTH", 64, 1, 5);
/*  277 */     addFunction("RAWTOHEX", 65, 1, 13);
/*  278 */     addFunction("REPEAT", 66, 2, 13);
/*  279 */     addFunction("REPLACE", 67, -1, 13);
/*  280 */     addFunction("RIGHT", 68, 2, 13);
/*  281 */     addFunction("RTRIM", 69, -1, 13);
/*  282 */     addFunction("SOUNDEX", 70, 1, 13);
/*  283 */     addFunction("SPACE", 71, 1, 13);
/*  284 */     addFunction("SUBSTR", 72, -1, 13);
/*  285 */     addFunction("SUBSTRING", 73, -1, 13);
/*  286 */     addFunction("UCASE", 74, 1, 13);
/*  287 */     addFunction("LOWER", 75, 1, 13);
/*  288 */     addFunction("UPPER", 76, 1, 13);
/*  289 */     addFunction("POSITION", 77, 2, 4);
/*  290 */     addFunction("TRIM", 78, -1, 13);
/*  291 */     addFunction("STRINGENCODE", 79, 1, 13);
/*  292 */     addFunction("STRINGDECODE", 80, 1, 13);
/*  293 */     addFunction("STRINGTOUTF8", 81, 1, 12);
/*  294 */     addFunction("UTF8TOSTRING", 82, 1, 13);
/*  295 */     addFunction("XMLATTR", 83, 2, 13);
/*  296 */     addFunctionWithNull("XMLNODE", 84, -1, 13);
/*  297 */     addFunction("XMLCOMMENT", 85, 1, 13);
/*  298 */     addFunction("XMLCDATA", 86, 1, 13);
/*  299 */     addFunction("XMLSTARTDOC", 87, 0, 13);
/*  300 */     addFunction("XMLTEXT", 88, -1, 13);
/*  301 */     addFunction("REGEXP_REPLACE", 89, -1, 13);
/*  302 */     addFunction("RPAD", 90, -1, 13);
/*  303 */     addFunction("LPAD", 91, -1, 13);
/*  304 */     addFunction("TO_CHAR", 93, -1, 13);
/*  305 */     addFunction("ORA_HASH", 95, -1, 4);
/*  306 */     addFunction("TRANSLATE", 94, 3, 13);
/*  307 */     addFunction("REGEXP_LIKE", 240, -1, 1);
/*      */ 
/*      */     
/*  310 */     addFunctionNotDeterministic("CURRENT_DATE", 117, 0, 10);
/*      */     
/*  312 */     addFunctionNotDeterministic("CURDATE", 100, 0, 10);
/*      */     
/*  314 */     addFunction("TO_DATE", 96, -1, 13);
/*  315 */     addFunction("TO_TIMESTAMP", 97, -1, 13);
/*  316 */     addFunction("ADD_MONTHS", 98, 2, 11);
/*      */     
/*  318 */     addFunctionNotDeterministic("GETDATE", 100, 0, 10);
/*      */     
/*  320 */     addFunctionNotDeterministic("CURRENT_TIME", 118, 0, 9);
/*      */     
/*  322 */     addFunctionNotDeterministic("CURTIME", 101, 0, 9);
/*      */     
/*  324 */     addFunctionNotDeterministic("CURRENT_TIMESTAMP", 119, -1, 11);
/*      */     
/*  326 */     addFunctionNotDeterministic("NOW", 112, -1, 11);
/*      */     
/*  328 */     addFunction("DATEADD", 102, 3, 11);
/*      */     
/*  330 */     addFunction("TIMESTAMPADD", 102, 3, 5);
/*      */     
/*  332 */     addFunction("DATEDIFF", 103, 3, 5);
/*      */     
/*  334 */     addFunction("TIMESTAMPDIFF", 103, 3, 5);
/*      */     
/*  336 */     addFunction("DAYNAME", 104, 1, 13);
/*      */     
/*  338 */     addFunction("DAYNAME", 104, 1, 13);
/*      */     
/*  340 */     addFunction("DAY", 105, 1, 4);
/*      */     
/*  342 */     addFunction("DAY_OF_MONTH", 105, 1, 4);
/*      */     
/*  344 */     addFunction("DAY_OF_WEEK", 106, 1, 4);
/*      */     
/*  346 */     addFunction("DAY_OF_YEAR", 107, 1, 4);
/*      */     
/*  348 */     addFunction("DAYOFMONTH", 105, 1, 4);
/*      */     
/*  350 */     addFunction("DAYOFWEEK", 106, 1, 4);
/*      */     
/*  352 */     addFunction("DAYOFYEAR", 107, 1, 4);
/*      */     
/*  354 */     addFunction("HOUR", 108, 1, 4);
/*      */     
/*  356 */     addFunction("MINUTE", 109, 1, 4);
/*      */     
/*  358 */     addFunction("MONTH", 110, 1, 4);
/*      */     
/*  360 */     addFunction("MONTHNAME", 111, 1, 13);
/*      */     
/*  362 */     addFunction("QUARTER", 113, 1, 4);
/*      */     
/*  364 */     addFunction("SECOND", 114, 1, 4);
/*      */     
/*  366 */     addFunction("WEEK", 115, 1, 4);
/*      */     
/*  368 */     addFunction("YEAR", 116, 1, 4);
/*      */     
/*  370 */     addFunction("EXTRACT", 120, 2, 4);
/*      */     
/*  372 */     addFunctionWithNull("FORMATDATETIME", 121, -1, 13);
/*      */     
/*  374 */     addFunctionWithNull("PARSEDATETIME", 122, -1, 11);
/*      */     
/*  376 */     addFunction("ISO_YEAR", 123, 1, 4);
/*      */     
/*  378 */     addFunction("ISO_WEEK", 124, 1, 4);
/*      */     
/*  380 */     addFunction("ISO_DAY_OF_WEEK", 125, 1, 4);
/*      */ 
/*      */     
/*  383 */     addFunctionNotDeterministic("DATABASE", 150, 0, 13);
/*      */     
/*  385 */     addFunctionNotDeterministic("USER", 151, 0, 13);
/*      */     
/*  387 */     addFunctionNotDeterministic("CURRENT_USER", 152, 0, 13);
/*      */     
/*  389 */     addFunctionNotDeterministic("IDENTITY", 153, 0, 5);
/*      */     
/*  391 */     addFunctionNotDeterministic("SCOPE_IDENTITY", 154, 0, 5);
/*      */     
/*  393 */     addFunctionNotDeterministic("IDENTITY_VAL_LOCAL", 153, 0, 5);
/*      */     
/*  395 */     addFunctionNotDeterministic("LAST_INSERT_ID", 153, 0, 5);
/*      */     
/*  397 */     addFunctionNotDeterministic("LASTVAL", 153, 0, 5);
/*      */     
/*  399 */     addFunctionNotDeterministic("AUTOCOMMIT", 155, 0, 1);
/*      */     
/*  401 */     addFunctionNotDeterministic("READONLY", 156, 0, 1);
/*      */     
/*  403 */     addFunction("DATABASE_PATH", 157, 0, 13);
/*      */     
/*  405 */     addFunctionNotDeterministic("LOCK_TIMEOUT", 158, 0, 4);
/*      */     
/*  407 */     addFunctionWithNull("IFNULL", 200, 2, 0);
/*      */     
/*  409 */     addFunctionWithNull("ISNULL", 200, 2, 0);
/*      */     
/*  411 */     addFunctionWithNull("CASEWHEN", 201, 3, 0);
/*      */     
/*  413 */     addFunctionWithNull("CONVERT", 202, 1, 0);
/*      */     
/*  415 */     addFunctionWithNull("CAST", 203, 1, 0);
/*      */     
/*  417 */     addFunctionWithNull("TRUNCATE_VALUE", 227, 3, 0);
/*      */     
/*  419 */     addFunctionWithNull("COALESCE", 204, -1, 0);
/*      */     
/*  421 */     addFunctionWithNull("NVL", 204, -1, 0);
/*      */     
/*  423 */     addFunctionWithNull("NVL2", 228, 3, 0);
/*      */     
/*  425 */     addFunctionWithNull("NULLIF", 205, 2, 0);
/*      */     
/*  427 */     addFunctionWithNull("CASE", 206, -1, 0);
/*      */     
/*  429 */     addFunctionNotDeterministic("NEXTVAL", 207, -1, 5);
/*      */     
/*  431 */     addFunctionNotDeterministic("CURRVAL", 208, -1, 5);
/*      */     
/*  433 */     addFunction("ARRAY_GET", 209, 2, 13);
/*      */     
/*  435 */     addFunction("ARRAY_CONTAINS", 230, 2, 1, false, true, true);
/*      */     
/*  437 */     addFunction("CSVREAD", 210, -1, 18, false, false, false);
/*      */     
/*  439 */     addFunction("CSVWRITE", 211, -1, 4, false, false, true);
/*      */     
/*  441 */     addFunctionNotDeterministic("MEMORY_FREE", 212, 0, 4);
/*      */     
/*  443 */     addFunctionNotDeterministic("MEMORY_USED", 213, 0, 4);
/*      */     
/*  445 */     addFunctionNotDeterministic("LOCK_MODE", 214, 0, 4);
/*      */     
/*  447 */     addFunctionNotDeterministic("SCHEMA", 215, 0, 13);
/*      */     
/*  449 */     addFunctionNotDeterministic("SESSION_ID", 216, 0, 4);
/*      */     
/*  451 */     addFunction("ARRAY_LENGTH", 217, 1, 4);
/*      */     
/*  453 */     addFunctionNotDeterministic("LINK_SCHEMA", 218, 6, 18);
/*      */     
/*  455 */     addFunctionWithNull("LEAST", 220, -1, 0);
/*      */     
/*  457 */     addFunctionWithNull("GREATEST", 219, -1, 0);
/*      */     
/*  459 */     addFunctionNotDeterministic("CANCEL_SESSION", 221, 1, 1);
/*      */     
/*  461 */     addFunction("SET", 222, 2, 0, false, false, true);
/*      */     
/*  463 */     addFunction("FILE_READ", 225, -1, 0, false, false, true);
/*      */     
/*  465 */     addFunction("FILE_WRITE", 232, 2, 5, false, false, true);
/*      */     
/*  467 */     addFunctionNotDeterministic("TRANSACTION_ID", 226, 0, 13);
/*      */     
/*  469 */     addFunctionWithNull("DECODE", 229, -1, 0);
/*      */     
/*  471 */     addFunctionNotDeterministic("DISK_SPACE_USED", 159, 1, 5);
/*      */     
/*  473 */     addFunction("H2VERSION", 231, 0, 13);
/*      */ 
/*      */     
/*  476 */     addFunctionWithNull("TABLE", 223, -1, 18);
/*      */     
/*  478 */     addFunctionWithNull("TABLE_DISTINCT", 224, -1, 18);
/*      */ 
/*      */ 
/*      */     
/*  482 */     addFunctionWithNull("ROW_NUMBER", 300, 0, 5);
/*      */ 
/*      */     
/*  485 */     addFunction("VALUES", 250, 1, 0, false, true, false);
/*      */   }
/*      */   
/*      */   protected Function(Database paramDatabase, FunctionInfo paramFunctionInfo) {
/*  489 */     this.database = paramDatabase;
/*  490 */     this.info = paramFunctionInfo;
/*  491 */     if (paramFunctionInfo.parameterCount == -1) {
/*  492 */       this.varArgs = New.arrayList();
/*      */     } else {
/*  494 */       this.args = new Expression[paramFunctionInfo.parameterCount];
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void addFunction(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/*  501 */     FunctionInfo functionInfo = new FunctionInfo();
/*  502 */     functionInfo.name = paramString;
/*  503 */     functionInfo.type = paramInt1;
/*  504 */     functionInfo.parameterCount = paramInt2;
/*  505 */     functionInfo.dataType = paramInt3;
/*  506 */     functionInfo.nullIfParameterIsNull = paramBoolean1;
/*  507 */     functionInfo.deterministic = paramBoolean2;
/*  508 */     functionInfo.bufferResultSetToLocalTemp = paramBoolean3;
/*  509 */     FUNCTIONS.put(paramString, functionInfo);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void addFunctionNotDeterministic(String paramString, int paramInt1, int paramInt2, int paramInt3) {
/*  514 */     addFunction(paramString, paramInt1, paramInt2, paramInt3, true, false, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void addFunction(String paramString, int paramInt1, int paramInt2, int paramInt3) {
/*  519 */     addFunction(paramString, paramInt1, paramInt2, paramInt3, true, true, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void addFunctionWithNull(String paramString, int paramInt1, int paramInt2, int paramInt3) {
/*  524 */     addFunction(paramString, paramInt1, paramInt2, paramInt3, false, true, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static FunctionInfo getFunctionInfo(String paramString) {
/*  535 */     return FUNCTIONS.get(paramString);
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
/*      */   public static Function getFunction(Database paramDatabase, String paramString) {
/*  547 */     if (!(paramDatabase.getSettings()).databaseToUpper)
/*      */     {
/*  549 */       paramString = StringUtils.toUpperEnglish(paramString);
/*      */     }
/*  551 */     FunctionInfo functionInfo = getFunctionInfo(paramString);
/*  552 */     if (functionInfo == null) {
/*  553 */       return null;
/*      */     }
/*  555 */     switch (functionInfo.type) {
/*      */       case 223:
/*      */       case 224:
/*  558 */         return new TableFunction(paramDatabase, functionInfo, Long.MAX_VALUE);
/*      */     } 
/*  560 */     return new Function(paramDatabase, functionInfo);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setParameter(int paramInt, Expression paramExpression) {
/*  571 */     if (this.varArgs != null) {
/*  572 */       this.varArgs.add(paramExpression);
/*      */     } else {
/*  574 */       if (paramInt >= this.args.length) {
/*  575 */         throw DbException.get(7001, new String[] { this.info.name, "" + this.args.length });
/*      */       }
/*      */       
/*  578 */       this.args[paramInt] = paramExpression;
/*      */     } 
/*      */   }
/*      */   
/*      */   private static strictfp double log10(double paramDouble) {
/*  583 */     return roundMagic(StrictMath.log(paramDouble) / StrictMath.log(10.0D));
/*      */   }
/*      */   
/*      */   public Value getValue(Session paramSession)
/*      */   {
/*  588 */     return getValueWithArgs(paramSession, this.args); } private Value getSimpleValue(Session paramSession, Value paramValue, Expression[] paramArrayOfExpression, Value[] paramArrayOfValue) { Value value11; ValueDouble valueDouble2; ValueInt valueInt8; ValueDouble valueDouble1; ValueBytes valueBytes2; ValueInt valueInt7; ValueUuid valueUuid; ValueInt valueInt6; ValueLong valueLong3; Value value10; ValueLong valueLong2; ValueNull valueNull3; Value value9; ValueBytes valueBytes1; Value value8; ValueInt valueInt5; Value value7; ValueInt valueInt4; ValueDate valueDate; ValueTime valueTime; ValueTimestamp valueTimestamp1; Value value6; ValueBoolean valueBoolean2; ValueInt valueInt3; ValueLong valueLong1; Value value5; ValueInt valueInt2; Value value4; ValueInt valueInt1; Value value3; ValueNull valueNull2; Value value2; ValueNull valueNull1; ValueBoolean valueBoolean1; double d; String str2; int j; SimpleDateFormat simpleDateFormat; long l; String str1; Mode mode; Value value13; int i; Value value12; byte b; Expression expression;
/*      */     String str3;
/*      */     char[] arrayOfChar;
/*      */     int k, n;
/*      */     ValueTimestamp valueTimestamp2;
/*      */     int m;
/*  594 */     switch (this.info.type)
/*      */     { case 0:
/*  596 */         return (paramValue.getSignum() >= 0) ? paramValue : paramValue.negate();
/*      */       
/*      */       case 1:
/*  599 */         valueDouble2 = ValueDouble.get(Math.acos(paramValue.getDouble()));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1134 */         return (Value)valueDouble2;case 2: valueDouble2 = ValueDouble.get(Math.asin(paramValue.getDouble())); return (Value)valueDouble2;case 3: valueDouble2 = ValueDouble.get(Math.atan(paramValue.getDouble())); return (Value)valueDouble2;case 8: valueDouble2 = ValueDouble.get(Math.ceil(paramValue.getDouble())); return (Value)valueDouble2;case 9: valueDouble2 = ValueDouble.get(Math.cos(paramValue.getDouble())); return (Value)valueDouble2;case 36: valueDouble2 = ValueDouble.get(Math.cosh(paramValue.getDouble())); return (Value)valueDouble2;case 10: d = Math.tan(paramValue.getDouble()); if (d == 0.0D) throw DbException.get(22012, getSQL());  valueDouble2 = ValueDouble.get(1.0D / d); return (Value)valueDouble2;case 11: valueDouble2 = ValueDouble.get(Math.toDegrees(paramValue.getDouble())); return (Value)valueDouble2;case 12: valueDouble2 = ValueDouble.get(Math.exp(paramValue.getDouble())); return (Value)valueDouble2;case 13: valueDouble2 = ValueDouble.get(Math.floor(paramValue.getDouble())); return (Value)valueDouble2;case 39: valueDouble2 = ValueDouble.get(Math.log(paramValue.getDouble())); return (Value)valueDouble2;case 14: if ((this.database.getMode()).logIsLogBase10) { valueDouble2 = ValueDouble.get(Math.log10(paramValue.getDouble())); } else { valueDouble2 = ValueDouble.get(Math.log(paramValue.getDouble())); }  return (Value)valueDouble2;case 15: valueDouble2 = ValueDouble.get(log10(paramValue.getDouble())); return (Value)valueDouble2;case 17: valueDouble2 = ValueDouble.get(Math.PI); return (Value)valueDouble2;case 19: valueDouble2 = ValueDouble.get(Math.toRadians(paramValue.getDouble())); return (Value)valueDouble2;case 20: if (paramValue != null) paramSession.getRandom().setSeed(paramValue.getInt());  valueDouble2 = ValueDouble.get(paramSession.getRandom().nextDouble()); return (Value)valueDouble2;case 22: valueDouble2 = ValueDouble.get(roundMagic(paramValue.getDouble())); return (Value)valueDouble2;case 23: return (Value)ValueInt.get(paramValue.getSignum());case 24: valueDouble1 = ValueDouble.get(Math.sin(paramValue.getDouble())); return (Value)valueDouble1;case 37: valueDouble1 = ValueDouble.get(Math.sinh(paramValue.getDouble())); return (Value)valueDouble1;case 25: valueDouble1 = ValueDouble.get(Math.sqrt(paramValue.getDouble())); return (Value)valueDouble1;case 26: valueDouble1 = ValueDouble.get(Math.tan(paramValue.getDouble())); return (Value)valueDouble1;case 38: valueDouble1 = ValueDouble.get(Math.tanh(paramValue.getDouble())); return (Value)valueDouble1;case 28: valueBytes2 = ValueBytes.getNoCopy(MathUtils.secureRandomBytes(paramValue.getInt())); return (Value)valueBytes2;case 33: valueBytes2 = ValueBytes.getNoCopy(CompressTool.getInstance().expand(paramValue.getBytesNoCopy())); return (Value)valueBytes2;case 34: return (Value)ValueInt.get(0);case 35: return (Value)ValueUuid.getNewRandom();case 50: str2 = paramValue.getString(); if (str2.length() == 0) { valueNull1 = ValueNull.INSTANCE; } else { valueInt6 = ValueInt.get(str2.charAt(0)); }  return (Value)valueInt6;case 51: return (Value)ValueLong.get(16L * length(paramValue));case 52: return ValueString.get(String.valueOf((char)paramValue.getInt()), (this.database.getMode()).treatEmptyStringsAsNull);case 53: case 61: valueLong2 = ValueLong.get(length(paramValue)); return (Value)valueLong2;case 64: valueLong2 = ValueLong.get(2L * length(paramValue)); return (Value)valueLong2;case 54: case 92: valueNull3 = ValueNull.INSTANCE; j = 0; str3 = ""; if (this.info.type == 92) { j = 1; str3 = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, 0).getString(); }  for (n = j; n < paramArrayOfExpression.length; n++) { Value value = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, n); if (value != ValueNull.INSTANCE) if (valueNull3 == ValueNull.INSTANCE) { value9 = value; } else { String str = value.getString(); if (!StringUtils.isNullOrEmpty(str3) && !StringUtils.isNullOrEmpty(str)) str = str3.concat(str);  value9 = ValueString.get(value9.getString().concat(str), (this.database.getMode()).treatEmptyStringsAsNull); }   }  if (this.info.type == 92 && str3 != null && value9 == ValueNull.INSTANCE) value9 = ValueString.get("", (this.database.getMode()).treatEmptyStringsAsNull);  return value9;case 56: value9 = ValueString.get(hexToRaw(paramValue.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value9;case 59: case 75: value9 = ValueString.get(paramValue.getString().toLowerCase(), (this.database.getMode()).treatEmptyStringsAsNull); return value9;case 65: value9 = ValueString.get(rawToHex(paramValue.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value9;case 70: value9 = ValueString.get(getSoundex(paramValue.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value9;case 71: j = Math.max(0, paramValue.getInt()); arrayOfChar = new char[j]; for (n = j - 1; n >= 0; n--) arrayOfChar[n] = ' ';  value9 = ValueString.get(new String(arrayOfChar), (this.database.getMode()).treatEmptyStringsAsNull); return value9;case 74: case 76: value9 = ValueString.get(paramValue.getString().toUpperCase(), (this.database.getMode()).treatEmptyStringsAsNull); return value9;case 79: value9 = ValueString.get(StringUtils.javaEncode(paramValue.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value9;case 80: value9 = ValueString.get(StringUtils.javaDecode(paramValue.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value9;case 81: return (Value)ValueBytes.getNoCopy(paramValue.getString().getBytes(Constants.UTF8));case 82: value8 = ValueString.get(new String(paramValue.getBytesNoCopy(), Constants.UTF8), (this.database.getMode()).treatEmptyStringsAsNull); return value8;case 85: value8 = ValueString.get(StringUtils.xmlComment(paramValue.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value8;case 86: value8 = ValueString.get(StringUtils.xmlCData(paramValue.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value8;case 87: value8 = ValueString.get(StringUtils.xmlStartDoc(), (this.database.getMode()).treatEmptyStringsAsNull); return value8;case 104: simpleDateFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH); value8 = ValueString.get(simpleDateFormat.format(paramValue.getDate()), (this.database.getMode()).treatEmptyStringsAsNull); return value8;case 105: valueInt5 = ValueInt.get(DateTimeUtils.getDatePart(paramValue.getDate(), 5)); return (Value)valueInt5;case 106: valueInt5 = ValueInt.get(DateTimeUtils.getDatePart(paramValue.getDate(), 7)); return (Value)valueInt5;case 107: valueInt5 = ValueInt.get(DateTimeUtils.getDatePart(paramValue.getDate(), 6)); return (Value)valueInt5;case 108: valueInt5 = ValueInt.get(DateTimeUtils.getDatePart(paramValue.getTimestamp(), 11)); return (Value)valueInt5;case 109: valueInt5 = ValueInt.get(DateTimeUtils.getDatePart(paramValue.getTimestamp(), 12)); return (Value)valueInt5;case 110: valueInt5 = ValueInt.get(DateTimeUtils.getDatePart(paramValue.getDate(), 2)); return (Value)valueInt5;case 111: simpleDateFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH); return ValueString.get(simpleDateFormat.format(paramValue.getDate()), (this.database.getMode()).treatEmptyStringsAsNull);case 113: valueInt4 = ValueInt.get((DateTimeUtils.getDatePart(paramValue.getDate(), 2) - 1) / 3 + 1); return (Value)valueInt4;case 114: valueInt4 = ValueInt.get(DateTimeUtils.getDatePart(paramValue.getTimestamp(), 13)); return (Value)valueInt4;case 115: valueInt4 = ValueInt.get(DateTimeUtils.getDatePart(paramValue.getDate(), 3)); return (Value)valueInt4;case 116: valueInt4 = ValueInt.get(DateTimeUtils.getDatePart(paramValue.getDate(), 1)); return (Value)valueInt4;case 123: valueInt4 = ValueInt.get(DateTimeUtils.getIsoYear(paramValue.getDate())); return (Value)valueInt4;case 124: valueInt4 = ValueInt.get(DateTimeUtils.getIsoWeek(paramValue.getDate())); return (Value)valueInt4;case 125: valueInt4 = ValueInt.get(DateTimeUtils.getIsoDayOfWeek(paramValue.getDate())); return (Value)valueInt4;case 100: case 117: l = paramSession.getTransactionStart(); return (Value)ValueDate.fromMillis(l);case 101: case 118: l = paramSession.getTransactionStart(); return (Value)ValueTime.fromMillis(l);case 112: case 119: l = paramSession.getTransactionStart(); valueTimestamp2 = ValueTimestamp.fromMillis(l); if (paramValue != null) { Mode mode1 = this.database.getMode(); valueTimestamp2 = (ValueTimestamp)valueTimestamp2.convertScale(mode1.convertOnlyToSmallerScale, paramValue.getInt()); }  return (Value)valueTimestamp2;case 150: value6 = ValueString.get(this.database.getShortName(), (this.database.getMode()).treatEmptyStringsAsNull); return value6;case 151: case 152: value6 = ValueString.get(paramSession.getUser().getName(), (this.database.getMode()).treatEmptyStringsAsNull); return value6;case 153: value6 = paramSession.getLastIdentity(); return value6;case 154: value6 = paramSession.getLastScopeIdentity(); return value6;case 155: valueBoolean2 = ValueBoolean.get(paramSession.getAutoCommit()); return (Value)valueBoolean2;case 156: valueBoolean2 = ValueBoolean.get(this.database.isReadOnly()); return (Value)valueBoolean2;case 157: str1 = this.database.getDatabasePath(); valueBoolean2 = (str1 == null) ? (ValueBoolean)ValueNull.INSTANCE : (ValueBoolean)ValueString.get(str1, (this.database.getMode()).treatEmptyStringsAsNull); return (Value)valueBoolean2;case 158: return (Value)ValueInt.get(paramSession.getLockTimeout());case 159: return (Value)ValueLong.get(getDiskSpaceUsed(paramSession, paramValue));case 202: case 203: paramValue = paramValue.convertTo(this.dataType); mode = this.database.getMode(); paramValue = paramValue.convertScale(mode.convertOnlyToSmallerScale, this.scale); paramValue = paramValue.convertPrecision(getPrecision(), false); return paramValue;case 212: paramSession.getUser().checkAdmin(); valueInt2 = ValueInt.get(Utils.getMemoryFree()); return (Value)valueInt2;case 213: paramSession.getUser().checkAdmin(); valueInt2 = ValueInt.get(Utils.getMemoryUsed()); return (Value)valueInt2;case 214: valueInt2 = ValueInt.get(this.database.getLockMode()); return (Value)valueInt2;case 215: return ValueString.get(paramSession.getCurrentSchemaName(), (this.database.getMode()).treatEmptyStringsAsNull);case 216: return (Value)ValueInt.get(paramSession.getId());case 200: value3 = paramValue; if (paramValue == ValueNull.INSTANCE) value3 = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, 1);  value3 = convertResult(value3); return value3;case 201: if (paramValue == ValueNull.INSTANCE || !paramValue.getBoolean().booleanValue()) { value13 = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, 2); } else { value13 = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, 1); }  value3 = value13.convertTo(this.dataType); return value3;case 229: i = -1; for (k = 1, m = paramArrayOfExpression.length - 1; k < m; k += 2) { if (this.database.areEqual(paramValue, getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, k))) { i = k + 1; break; }  }  if (i < 0 && paramArrayOfExpression.length % 2 == 0) i = paramArrayOfExpression.length - 1;  k = (i < 0) ? ValueNull.INSTANCE : getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, i); value3 = k.convertTo(this.dataType); return value3;case 228: if (paramValue == ValueNull.INSTANCE) { value12 = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, 2); } else { value12 = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, 1); }  value3 = value12.convertTo(this.dataType); return value3;case 204: value3 = paramValue; for (b = 0; b < paramArrayOfExpression.length; b++) { Value value = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, b); if (value != ValueNull.INSTANCE) { value3 = value.convertTo(this.dataType); break; }  }  return value3;case 219: case 220: valueNull2 = ValueNull.INSTANCE; for (b = 0; b < paramArrayOfExpression.length; b++) { Value value = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, b); if (value != ValueNull.INSTANCE) { value = value.convertTo(this.dataType); if (valueNull2 == ValueNull.INSTANCE) { value2 = value; } else { m = this.database.compareTypeSafe(value2, value); if (this.info.type == 219 && m < 0) { value2 = value; } else if (this.info.type == 220 && m > 0) { value2 = value; }  }  }  }  return value2;case 206: expression = null; if (paramValue == null) { for (k = 1, m = paramArrayOfExpression.length - 1; k < m; k += 2) { Value value = paramArrayOfExpression[k].getValue(paramSession); if (value != ValueNull.INSTANCE && value.getBoolean().booleanValue()) { expression = paramArrayOfExpression[k + 1]; break; }  }  } else if (paramValue != ValueNull.INSTANCE) { for (k = 1, m = paramArrayOfExpression.length - 1; k < m; k += 2) { Value value = paramArrayOfExpression[k].getValue(paramSession); if (this.database.areEqual(paramValue, value)) { expression = paramArrayOfExpression[k + 1]; break; }  }  }  if (expression == null && paramArrayOfExpression.length % 2 == 0) expression = paramArrayOfExpression[paramArrayOfExpression.length - 1];  k = (expression == null) ? ValueNull.INSTANCE : expression.getValue(paramSession); value2 = k.convertTo(this.dataType); return value2;case 209: if (paramValue.getType() == 17) { Value value = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, 1); k = value.getInt(); Value[] arrayOfValue = ((ValueArray)paramValue).getList(); if (k < 1 || k > arrayOfValue.length) { valueNull1 = ValueNull.INSTANCE; } else { value2 = arrayOfValue[k - 1]; }  } else { valueNull1 = ValueNull.INSTANCE; }  return (Value)valueNull1;case 217: if (paramValue.getType() == 17) { Value[] arrayOfValue = ((ValueArray)paramValue).getList(); ValueInt valueInt = ValueInt.get(arrayOfValue.length); } else { valueNull1 = ValueNull.INSTANCE; }  return (Value)valueNull1;case 230: valueBoolean1 = ValueBoolean.get(false); if (paramValue.getType() == 17) { Value value = getNullOrValue(paramSession, paramArrayOfExpression, paramArrayOfValue, 1); Value[] arrayOfValue = ((ValueArray)paramValue).getList(); for (Value value14 : arrayOfValue) { if (value14.equals(value)) { valueBoolean1 = ValueBoolean.get(true); break; }  }  }  return (Value)valueBoolean1;case 221: valueBoolean1 = ValueBoolean.get(cancelStatement(paramSession, paramValue.getInt())); return (Value)valueBoolean1;case 226: value1 = paramSession.getTransactionId(); return value1; }  Value value1 = null; return value1; }
/*      */ 
/*      */   
/*      */   private Value convertResult(Value paramValue) {
/* 1138 */     return paramValue.convertTo(this.dataType);
/*      */   }
/*      */   
/*      */   private static boolean cancelStatement(Session paramSession, int paramInt) {
/* 1142 */     paramSession.getUser().checkAdmin();
/* 1143 */     Session[] arrayOfSession = paramSession.getDatabase().getSessions(false);
/* 1144 */     for (Session session : arrayOfSession) {
/* 1145 */       if (session.getId() == paramInt) {
/* 1146 */         Command command = session.getCurrentCommand();
/* 1147 */         if (command == null) {
/* 1148 */           return false;
/*      */         }
/* 1150 */         command.cancel();
/* 1151 */         return true;
/*      */       } 
/*      */     } 
/* 1154 */     return false;
/*      */   }
/*      */   
/*      */   private static long getDiskSpaceUsed(Session paramSession, Value paramValue) {
/* 1158 */     Parser parser = new Parser(paramSession);
/* 1159 */     String str = paramValue.getString();
/* 1160 */     Table table = parser.parseTableName(str);
/* 1161 */     return table.getDiskSpaceUsed();
/*      */   }
/*      */   
/*      */   private static Value getNullOrValue(Session paramSession, Expression[] paramArrayOfExpression, Value[] paramArrayOfValue, int paramInt)
/*      */   {
/* 1166 */     if (paramInt >= paramArrayOfExpression.length) {
/* 1167 */       return null;
/*      */     }
/* 1169 */     Value value = paramArrayOfValue[paramInt];
/* 1170 */     if (value == null) {
/* 1171 */       Expression expression = paramArrayOfExpression[paramInt];
/* 1172 */       if (expression == null) {
/* 1173 */         return null;
/*      */       }
/* 1175 */       value = paramArrayOfValue[paramInt] = expression.getValue(paramSession);
/*      */     } 
/* 1177 */     return value; } private Value getValueWithArgs(Session paramSession, Expression[] paramArrayOfExpression) { ValueDouble valueDouble2; ValueLong valueLong5; ValueDouble valueDouble1; ValueBytes valueBytes; ValueInt valueInt5; Value value16; ValueInt valueInt4; Value value15; ValueInt valueInt3; Value value14; ValueLong valueLong4; Value value13; ValueTimestamp valueTimestamp3; Value value12; ValueTimestamp valueTimestamp2; ValueLong valueLong3; ValueInt valueInt2; Value value11; ValueTimestamp valueTimestamp1; Value value10; ValueLong valueLong2; ValueResultSet valueResultSet; ValueInt valueInt1; Value value9; ValueNull valueNull; ValueLong valueLong1; Value value8; ValueBoolean valueBoolean; long l; double d; String str4; int j; String str3; int i; Sequence sequence; String str2; JdbcConnection jdbcConnection; Variable variable; String str1, str8; int k; String str7; SequenceValue sequenceValue; String str6; ResultSet resultSet; Csv csv1; boolean bool; String str5, str11; int n; String str10; Csv csv2; String str9; int m, i1;
/*      */     String str12, str13;
/*      */     char c;
/*      */     String[] arrayOfString;
/* 1181 */     Value[] arrayOfValue = new Value[paramArrayOfExpression.length];
/* 1182 */     if (this.info.nullIfParameterIsNull) {
/* 1183 */       for (byte b = 0; b < paramArrayOfExpression.length; b++) {
/* 1184 */         Expression expression = paramArrayOfExpression[b];
/* 1185 */         Value value = expression.getValue(paramSession);
/* 1186 */         if (value == ValueNull.INSTANCE) {
/* 1187 */           return (Value)ValueNull.INSTANCE;
/*      */         }
/* 1189 */         arrayOfValue[b] = value;
/*      */       } 
/*      */     }
/* 1192 */     Value value1 = getNullOrValue(paramSession, paramArrayOfExpression, arrayOfValue, 0);
/* 1193 */     Value value2 = getSimpleValue(paramSession, value1, paramArrayOfExpression, arrayOfValue);
/* 1194 */     if (value2 != null) {
/* 1195 */       return value2;
/*      */     }
/* 1197 */     Value value3 = getNullOrValue(paramSession, paramArrayOfExpression, arrayOfValue, 1);
/* 1198 */     Value value4 = getNullOrValue(paramSession, paramArrayOfExpression, arrayOfValue, 2);
/* 1199 */     Value value5 = getNullOrValue(paramSession, paramArrayOfExpression, arrayOfValue, 3);
/* 1200 */     Value value6 = getNullOrValue(paramSession, paramArrayOfExpression, arrayOfValue, 4);
/* 1201 */     Value value7 = getNullOrValue(paramSession, paramArrayOfExpression, arrayOfValue, 5);
/*      */     
/* 1203 */     switch (this.info.type) {
/*      */       case 4:
/* 1205 */         return (Value)ValueDouble.get(Math.atan2(value1.getDouble(), value3.getDouble()));
/*      */ 
/*      */       
/*      */       case 5:
/* 1209 */         valueLong5 = ValueLong.get(value1.getLong() & value3.getLong());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1683 */         return (Value)valueLong5;case 6: valueLong5 = ValueLong.get(value1.getLong() | value3.getLong()); return (Value)valueLong5;case 7: valueLong5 = ValueLong.get(value1.getLong() ^ value3.getLong()); return (Value)valueLong5;case 16: l = value3.getLong(); if (l == 0L) throw DbException.get(22012, getSQL());  valueLong5 = ValueLong.get(value1.getLong() % l); return (Value)valueLong5;case 18: valueDouble1 = ValueDouble.get(Math.pow(value1.getDouble(), value3.getDouble())); return (Value)valueDouble1;case 21: d = (value3 == null) ? 1.0D : Math.pow(10.0D, value3.getDouble()); valueDouble1 = ValueDouble.get(Math.round(value1.getDouble() * d) / d); return (Value)valueDouble1;case 27: if (value1.getType() == 11) { Timestamp timestamp = value1.getTimestamp(); Calendar calendar = Calendar.getInstance(); calendar.setTime(timestamp); calendar.set(11, 0); calendar.set(12, 0); calendar.set(13, 0); calendar.set(14, 0); valueTimestamp1 = ValueTimestamp.fromMillis(calendar.getTimeInMillis()); } else if (value1.getType() == 10) { ValueDate valueDate = (ValueDate)value1; Calendar calendar = Calendar.getInstance(); calendar.setTime(valueDate.getDate()); calendar.set(11, 0); calendar.set(12, 0); calendar.set(13, 0); calendar.set(14, 0); valueTimestamp1 = ValueTimestamp.fromMillis(calendar.getTimeInMillis()); } else if (value1.getType() == 13) { ValueString valueString = (ValueString)value1; Calendar calendar = Calendar.getInstance(); calendar.setTime(ValueTimestamp.parse(valueString.getString()).getDate()); calendar.set(11, 0); calendar.set(12, 0); calendar.set(13, 0); calendar.set(14, 0); valueTimestamp1 = ValueTimestamp.fromMillis(calendar.getTimeInMillis()); } else { d = value1.getDouble(); boolean bool1 = (value3 == null) ? false : value3.getInt(); double d1 = Math.pow(10.0D, bool1); double d2 = d * d1; valueDouble1 = ValueDouble.get(((d < 0.0D) ? Math.ceil(d2) : Math.floor(d2)) / d1); }  return (Value)valueDouble1;case 29: valueBytes = ValueBytes.getNoCopy(getHash(value1.getString(), value3.getBytesNoCopy(), value4.getInt())); return (Value)valueBytes;case 30: valueBytes = ValueBytes.getNoCopy(encrypt(value1.getString(), value3.getBytesNoCopy(), value4.getBytesNoCopy())); return (Value)valueBytes;case 31: valueBytes = ValueBytes.getNoCopy(decrypt(value1.getString(), value3.getBytesNoCopy(), value4.getBytesNoCopy())); return (Value)valueBytes;case 32: str4 = null; if (value3 != null) str4 = value3.getString();  valueBytes = ValueBytes.getNoCopy(CompressTool.getInstance().compress(value1.getBytesNoCopy(), str4)); return (Value)valueBytes;case 55: return (Value)ValueInt.get(getDifference(value1.getString(), value3.getString()));case 57: if (value3 == ValueNull.INSTANCE || value4 == ValueNull.INSTANCE) { value16 = value3; } else { value16 = ValueString.get(insert(value1.getString(), value3.getInt(), value4.getInt(), value5.getString()), (this.database.getMode()).treatEmptyStringsAsNull); }  return value16;case 60: value16 = ValueString.get(left(value1.getString(), value3.getInt()), (this.database.getMode()).treatEmptyStringsAsNull); return value16;case 62: j = (value4 == null) ? 0 : value4.getInt(); valueInt4 = ValueInt.get(locate(value1.getString(), value3.getString(), j)); return (Value)valueInt4;case 58: j = (value4 == null) ? 0 : value4.getInt(); valueInt4 = ValueInt.get(locate(value3.getString(), value1.getString(), j)); return (Value)valueInt4;case 66: j = Math.max(0, value3.getInt()); value15 = ValueString.get(repeat(value1.getString(), j), (this.database.getMode()).treatEmptyStringsAsNull); return value15;case 67: str3 = value1.getString(); str8 = value3.getString(); str11 = (value4 == null) ? "" : value4.getString(); value15 = ValueString.get(replace(str3, str8, str11), (this.database.getMode()).treatEmptyStringsAsNull); return value15;case 68: value15 = ValueString.get(right(value1.getString(), value3.getInt()), (this.database.getMode()).treatEmptyStringsAsNull); return value15;case 63: value15 = ValueString.get(StringUtils.trim(value1.getString(), true, false, (value3 == null) ? " " : value3.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value15;case 78: value15 = ValueString.get(StringUtils.trim(value1.getString(), true, true, (value3 == null) ? " " : value3.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value15;case 69: value15 = ValueString.get(StringUtils.trim(value1.getString(), false, true, (value3 == null) ? " " : value3.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value15;case 72: case 73: str3 = value1.getString(); k = value3.getInt(); if (k < 0) k = str3.length() + k + 1;  n = (value4 == null) ? str3.length() : value4.getInt(); value15 = ValueString.get(substring(str3, k, n), (this.database.getMode()).treatEmptyStringsAsNull); return value15;case 77: return (Value)ValueInt.get(locate(value1.getString(), value3.getString(), 0));case 83: value14 = ValueString.get(StringUtils.xmlAttr(value1.getString(), value3.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value14;case 84: str3 = (value3 == null) ? null : ((value3 == ValueNull.INSTANCE) ? null : value3.getString()); str7 = (value4 == null) ? null : ((value4 == ValueNull.INSTANCE) ? null : value4.getString()); n = (value5 == null) ? 1 : value5.getBoolean().booleanValue(); value14 = ValueString.get(StringUtils.xmlNode(value1.getString(), str3, str7, n), (this.database.getMode()).treatEmptyStringsAsNull); return value14;case 89: str3 = value3.getString(); str7 = value4.getString(); str10 = (value5 == null || value5.getString() == null) ? "" : value4.getString(); i1 = makeRegexpFlags(str10); try { value14 = ValueString.get(Pattern.compile(str3, i1).matcher(value1.getString()).replaceAll(str7), (this.database.getMode()).treatEmptyStringsAsNull); } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) { throw DbException.get(22025, stringIndexOutOfBoundsException, new String[] { str7 }); } catch (PatternSyntaxException patternSyntaxException) { throw DbException.get(22025, patternSyntaxException, new String[] { str3 }); } catch (IllegalArgumentException illegalArgumentException) { throw DbException.get(22025, illegalArgumentException, new String[] { str7 }); }  return value14;case 90: value14 = ValueString.get(StringUtils.pad(value1.getString(), value3.getInt(), (value4 == null) ? null : value4.getString(), true), (this.database.getMode()).treatEmptyStringsAsNull); return value14;case 91: value14 = ValueString.get(StringUtils.pad(value1.getString(), value3.getInt(), (value4 == null) ? null : value4.getString(), false), (this.database.getMode()).treatEmptyStringsAsNull); return value14;case 95: return (Value)ValueLong.get(oraHash(value1.getString(), (value3 == null) ? null : Integer.valueOf(value3.getInt()), (value4 == null) ? null : Integer.valueOf(value4.getInt())).intValue());case 93: switch (value1.getType()) { case 9: case 10: case 11: value13 = ValueString.get(ToChar.toChar(value1.getTimestamp(), (value3 == null) ? null : value3.getString(), (value4 == null) ? null : value4.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value13;case 3: case 4: case 5: case 6: case 7: case 8: value13 = ValueString.get(ToChar.toChar(value1.getBigDecimal(), (value3 == null) ? null : value3.getString(), (value4 == null) ? null : value4.getString()), (this.database.getMode()).treatEmptyStringsAsNull); return value13; }  value13 = ValueString.get(value1.getString(), (this.database.getMode()).treatEmptyStringsAsNull); return value13;case 96: valueTimestamp3 = ValueTimestamp.get(ToDateParser.toDate(value1.getString(), (value3 == null) ? null : value3.getString())); return (Value)valueTimestamp3;case 97: valueTimestamp3 = ValueTimestamp.get(ToDateParser.toTimestamp(value1.getString(), (value3 == null) ? null : value3.getString())); return (Value)valueTimestamp3;case 98: valueTimestamp3 = ValueTimestamp.get(DateTimeUtils.addMonths(value1.getTimestamp(), value3.getInt())); return (Value)valueTimestamp3;case 94: str3 = value3.getString(); str7 = value4.getString(); value12 = ValueString.get(translate(value1.getString(), str3, str7), (this.database.getMode()).treatEmptyStringsAsNull); return value12;case 231: value12 = ValueString.get(Constants.getVersion(), (this.database.getMode()).treatEmptyStringsAsNull); return value12;case 102: return (Value)ValueTimestamp.get(dateadd(value1.getString(), value3.getLong(), value4.getTimestamp()));case 103: return (Value)ValueLong.get(datediff(value1.getString(), value3.getTimestamp(), value4.getTimestamp()));case 120: i = getDatePart(value1.getString()); return (Value)ValueInt.get(DateTimeUtils.getDatePart(value3.getTimestamp(), i));case 121: if (value1 == ValueNull.INSTANCE || value3 == ValueNull.INSTANCE) { ValueNull valueNull1 = ValueNull.INSTANCE; } else { String str = (value4 == null) ? null : ((value4 == ValueNull.INSTANCE) ? null : value4.getString()); str7 = (value5 == null) ? null : ((value5 == ValueNull.INSTANCE) ? null : value5.getString()); value11 = ValueString.get(DateTimeUtils.formatDateTime(value1.getTimestamp(), value3.getString(), str, str7), (this.database.getMode()).treatEmptyStringsAsNull); }  return value11;case 122: if (value1 == ValueNull.INSTANCE || value3 == ValueNull.INSTANCE) { ValueNull valueNull1 = ValueNull.INSTANCE; } else { String str = (value4 == null) ? null : ((value4 == ValueNull.INSTANCE) ? null : value4.getString()); str7 = (value5 == null) ? null : ((value5 == ValueNull.INSTANCE) ? null : value5.getString()); Date date = DateTimeUtils.parseDateTime(value1.getString(), value3.getString(), str, str7); valueTimestamp1 = ValueTimestamp.fromMillis(date.getTime()); }  return (Value)valueTimestamp1;case 205: valueTimestamp1 = this.database.areEqual(value1, value3) ? (ValueTimestamp)ValueNull.INSTANCE : (ValueTimestamp)value1; return (Value)valueTimestamp1;case 207: sequence = getSequence(paramSession, value1, value3); sequenceValue = new SequenceValue(sequence); return sequenceValue.getValue(paramSession);case 208: sequence = getSequence(paramSession, value1, value3); return (Value)ValueLong.get(sequence.getCurrentValue());case 210: str2 = value1.getString(); str6 = (value3 == null) ? null : value3.getString(); csv2 = new Csv(); str12 = (value4 == null) ? null : value4.getString(); str13 = null; if (str12 != null && str12.indexOf('=') >= 0) { str13 = csv2.setOptions(str12); } else { str13 = str12; String str14 = (value5 == null) ? null : value5.getString(); String str15 = (value6 == null) ? null : value6.getString(); String str16 = (value7 == null) ? null : value7.getString(); Value value = getNullOrValue(paramSession, paramArrayOfExpression, arrayOfValue, 6); String str17 = (value == null) ? null : value.getString(); setCsvDelimiterEscape(csv2, str14, str15, str16); csv2.setNullString(str17); }  c = csv2.getFieldSeparatorRead(); arrayOfString = StringUtils.arraySplit(str6, c, true); try { ValueResultSet valueResultSet1 = ValueResultSet.get(csv2.read(str2, arrayOfString, str13)); valueResultSet = valueResultSet1; } catch (SQLException sQLException) { throw DbException.convert(sQLException); }  return (Value)valueResultSet;case 218: paramSession.getUser().checkAdmin(); jdbcConnection = paramSession.createConnection(false); resultSet = LinkSchema.linkSchema((Connection)jdbcConnection, value1.getString(), value3.getString(), value4.getString(), value5.getString(), value6.getString(), value7.getString()); valueResultSet = ValueResultSet.get(resultSet); return (Value)valueResultSet;case 211: paramSession.getUser().checkAdmin(); jdbcConnection = paramSession.createConnection(false); csv1 = new Csv(); str9 = (value4 == null) ? null : value4.getString(); str12 = null; if (str9 != null && str9.indexOf('=') >= 0) { str12 = csv1.setOptions(str9); } else { str12 = str9; str13 = (value5 == null) ? null : value5.getString(); String str14 = (value6 == null) ? null : value6.getString(); String str15 = (value7 == null) ? null : value7.getString(); Value value17 = getNullOrValue(paramSession, paramArrayOfExpression, arrayOfValue, 6); String str16 = (value17 == null) ? null : value17.getString(); Value value18 = getNullOrValue(paramSession, paramArrayOfExpression, arrayOfValue, 7); String str17 = (value18 == null) ? null : value18.getString(); setCsvDelimiterEscape(csv1, str13, str14, str15); csv1.setNullString(str16); if (str17 != null) csv1.setLineSeparator(str17);  }  try { int i2 = csv1.write((Connection)jdbcConnection, value1.getString(), value3.getString(), str12); valueInt1 = ValueInt.get(i2); } catch (SQLException sQLException) { throw DbException.convert(sQLException); }  return (Value)valueInt1;case 222: variable = (Variable)paramArrayOfExpression[0]; paramSession.setVariable(variable.getName(), value3); value9 = value3; return value9;case 225: paramSession.getUser().checkAdmin(); str1 = value1.getString(); bool = (paramArrayOfExpression.length == 1) ? true : false; try { long l1 = FileUtils.size(str1); AutoCloseInputStream autoCloseInputStream = new AutoCloseInputStream(FileUtils.newInputStream(str1)); if (bool) { value9 = this.database.getLobStorage().createBlob((InputStream)autoCloseInputStream, l1); } else { InputStreamReader inputStreamReader; if (value3 == ValueNull.INSTANCE) { inputStreamReader = new InputStreamReader((InputStream)autoCloseInputStream); } else { inputStreamReader = new InputStreamReader((InputStream)autoCloseInputStream, value3.getString()); }  value9 = this.database.getLobStorage().createClob(inputStreamReader, l1); }  paramSession.addTemporaryLob(value9); } catch (IOException iOException) { throw DbException.convertIOException(iOException, str1); }  return value9;case 232: paramSession.getUser().checkAdmin(); valueNull = ValueNull.INSTANCE; str1 = value3.getString(); try { Throwable throwable; FileOutputStream fileOutputStream = new FileOutputStream(str1); InputStream inputStream = value1.getInputStream(); str12 = null; try { valueLong1 = ValueLong.get(IOUtils.copyAndClose(inputStream, fileOutputStream)); } catch (Throwable throwable1) { throwable = throwable1 = null; throw throwable1; } finally { if (inputStream != null) if (throwable != null) { try { inputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  } else { inputStream.close(); }   }  } catch (IOException iOException) { throw DbException.convertIOException(iOException, str1); }  return (Value)valueLong1;case 227: value8 = value1.convertPrecision(value3.getLong(), value4.getBoolean().booleanValue()); return value8;case 88: if (value3 == null) { value8 = ValueString.get(StringUtils.xmlText(value1.getString()), (this.database.getMode()).treatEmptyStringsAsNull); } else { value8 = ValueString.get(StringUtils.xmlText(value1.getString(), value3.getBoolean().booleanValue()), (this.database.getMode()).treatEmptyStringsAsNull); }  return value8;case 240: str1 = value3.getString(); str5 = (value4 == null || value4.getString() == null) ? "" : value4.getString(); m = makeRegexpFlags(str5); try { valueBoolean = ValueBoolean.get(Pattern.compile(str1, m).matcher(value1.getString()).find()); } catch (PatternSyntaxException patternSyntaxException) { throw DbException.get(22025, patternSyntaxException, new String[] { str1 }); }  return (Value)valueBoolean;
/*      */       case 250:
/*      */         return paramSession.getVariable(paramArrayOfExpression[0].getSchemaName() + "." + paramArrayOfExpression[0].getTableName() + "." + paramArrayOfExpression[0].getColumnName());
/*      */     } 
/*      */     throw DbException.throwInternalError("type=" + this.info.type); } private Sequence getSequence(Session paramSession, Value paramValue1, Value paramValue2) { String str1, str2;
/* 1688 */     if (paramValue2 == null) {
/* 1689 */       Parser parser = new Parser(paramSession);
/* 1690 */       String str = paramValue1.getString();
/* 1691 */       Expression expression = parser.parseExpression(str);
/* 1692 */       if (expression instanceof ExpressionColumn) {
/* 1693 */         ExpressionColumn expressionColumn = (ExpressionColumn)expression;
/* 1694 */         str1 = expressionColumn.getOriginalTableAliasName();
/* 1695 */         if (str1 == null) {
/* 1696 */           str1 = paramSession.getCurrentSchemaName();
/* 1697 */           str2 = str;
/*      */         } else {
/* 1699 */           str2 = expressionColumn.getColumnName();
/*      */         } 
/*      */       } else {
/* 1702 */         throw DbException.getSyntaxError(str, 1);
/*      */       } 
/*      */     } else {
/* 1705 */       str1 = paramValue1.getString();
/* 1706 */       str2 = paramValue2.getString();
/*      */     } 
/* 1708 */     Schema schema = this.database.findSchema(str1);
/* 1709 */     if (schema == null) {
/* 1710 */       str1 = StringUtils.toUpperEnglish(str1);
/* 1711 */       schema = this.database.getSchema(str1);
/*      */     } 
/* 1713 */     Sequence sequence = schema.findSequence(str2);
/* 1714 */     if (sequence == null) {
/* 1715 */       str2 = StringUtils.toUpperEnglish(str2);
/* 1716 */       sequence = schema.getSequence(str2);
/*      */     } 
/* 1718 */     return sequence; }
/*      */ 
/*      */   
/*      */   private static long length(Value paramValue) {
/* 1722 */     switch (paramValue.getType()) {
/*      */       case 12:
/*      */       case 15:
/*      */       case 16:
/*      */       case 19:
/* 1727 */         return paramValue.getPrecision();
/*      */     } 
/* 1729 */     return paramValue.getString().length();
/*      */   }
/*      */ 
/*      */   
/*      */   private static byte[] getPaddedArrayCopy(byte[] paramArrayOfbyte, int paramInt) {
/* 1734 */     int i = MathUtils.roundUpInt(paramArrayOfbyte.length, paramInt);
/* 1735 */     byte[] arrayOfByte = DataUtils.newBytes(i);
/* 1736 */     System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramArrayOfbyte.length);
/* 1737 */     return arrayOfByte;
/*      */   }
/*      */   
/*      */   private static byte[] decrypt(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 1741 */     BlockCipher blockCipher = CipherFactory.getBlockCipher(paramString);
/* 1742 */     byte[] arrayOfByte1 = getPaddedArrayCopy(paramArrayOfbyte1, blockCipher.getKeyLength());
/* 1743 */     blockCipher.setKey(arrayOfByte1);
/* 1744 */     byte[] arrayOfByte2 = getPaddedArrayCopy(paramArrayOfbyte2, 16);
/* 1745 */     blockCipher.decrypt(arrayOfByte2, 0, arrayOfByte2.length);
/* 1746 */     return arrayOfByte2;
/*      */   }
/*      */   
/*      */   private static byte[] encrypt(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/* 1750 */     BlockCipher blockCipher = CipherFactory.getBlockCipher(paramString);
/* 1751 */     byte[] arrayOfByte1 = getPaddedArrayCopy(paramArrayOfbyte1, blockCipher.getKeyLength());
/* 1752 */     blockCipher.setKey(arrayOfByte1);
/* 1753 */     byte[] arrayOfByte2 = getPaddedArrayCopy(paramArrayOfbyte2, 16);
/* 1754 */     blockCipher.encrypt(arrayOfByte2, 0, arrayOfByte2.length);
/* 1755 */     return arrayOfByte2;
/*      */   }
/*      */   
/*      */   private static byte[] getHash(String paramString, byte[] paramArrayOfbyte, int paramInt) {
/* 1759 */     if (!"SHA256".equalsIgnoreCase(paramString)) {
/* 1760 */       throw DbException.getInvalidValueException("algorithm", paramString);
/*      */     }
/* 1762 */     for (byte b = 0; b < paramInt; b++) {
/* 1763 */       paramArrayOfbyte = SHA256.getHash(paramArrayOfbyte, false);
/*      */     }
/* 1765 */     return paramArrayOfbyte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isDatePart(String paramString) {
/* 1775 */     Integer integer = DATE_PART.get(StringUtils.toUpperEnglish(paramString));
/* 1776 */     return (integer != null);
/*      */   }
/*      */   
/*      */   private static int getDatePart(String paramString) {
/* 1780 */     Integer integer = DATE_PART.get(StringUtils.toUpperEnglish(paramString));
/* 1781 */     if (integer == null) {
/* 1782 */       throw DbException.getInvalidValueException("date part", paramString);
/*      */     }
/* 1784 */     return integer.intValue();
/*      */   }
/*      */   
/*      */   private static Timestamp dateadd(String paramString, long paramLong, Timestamp paramTimestamp) {
/* 1788 */     int i = getDatePart(paramString);
/* 1789 */     if (i == 14) {
/* 1790 */       Timestamp timestamp1 = new Timestamp(paramTimestamp.getTime() + paramLong);
/* 1791 */       timestamp1.setNanos(timestamp1.getNanos() + paramTimestamp.getNanos() % 1000000);
/* 1792 */       return timestamp1;
/*      */     } 
/*      */ 
/*      */     
/* 1796 */     if (paramLong > 2147483647L) {
/* 1797 */       throw DbException.getInvalidValueException("DATEADD count", Long.valueOf(paramLong));
/*      */     }
/* 1799 */     Calendar calendar = Calendar.getInstance();
/* 1800 */     int j = paramTimestamp.getNanos() % 1000000;
/* 1801 */     calendar.setTime(paramTimestamp);
/* 1802 */     calendar.add(i, (int)paramLong);
/* 1803 */     long l = calendar.getTime().getTime();
/* 1804 */     Timestamp timestamp = new Timestamp(l);
/* 1805 */     timestamp.setNanos(timestamp.getNanos() + j);
/* 1806 */     return timestamp;
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
/*      */   private static long datediff(String paramString, Timestamp paramTimestamp1, Timestamp paramTimestamp2) {
/*      */     long l3, l4;
/* 1822 */     int i = getDatePart(paramString);
/* 1823 */     Calendar calendar = Calendar.getInstance();
/* 1824 */     long l1 = paramTimestamp1.getTime(), l2 = paramTimestamp2.getTime();
/*      */ 
/*      */     
/* 1827 */     TimeZone timeZone = calendar.getTimeZone();
/* 1828 */     calendar.setTime(paramTimestamp1);
/* 1829 */     l1 += timeZone.getOffset(calendar.get(0), calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), calendar.get(14));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1834 */     calendar.setTime(paramTimestamp2);
/* 1835 */     l2 += timeZone.getOffset(calendar.get(0), calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), calendar.get(14));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1840 */     switch (i) {
/*      */       case 14:
/* 1842 */         return l2 - l1;
/*      */       
/*      */       case 3:
/*      */       case 6:
/*      */       case 11:
/*      */       case 12:
/*      */       case 13:
/* 1849 */         l3 = 3600000L;
/* 1850 */         l4 = Math.min(l1 / l3 * l3, l2 / l3 * l3);
/* 1851 */         l1 -= l4;
/* 1852 */         l2 -= l4;
/* 1853 */         switch (i) {
/*      */           case 13:
/* 1855 */             return l2 / 1000L - l1 / 1000L;
/*      */           case 12:
/* 1857 */             return l2 / 60000L - l1 / 60000L;
/*      */           case 11:
/* 1859 */             return l2 / l3 - l1 / l3;
/*      */           case 6:
/* 1861 */             return l2 / l3 * 24L - l1 / l3 * 24L;
/*      */           case 3:
/* 1863 */             return l2 / l3 * 24L * 7L - l1 / l3 * 24L * 7L;
/*      */         } 
/* 1865 */         throw DbException.throwInternalError("field:" + i);
/*      */ 
/*      */       
/*      */       case 5:
/* 1869 */         return l2 / 86400000L - l1 / 86400000L;
/*      */     } 
/*      */ 
/*      */     
/* 1873 */     calendar.setTimeInMillis(l1);
/* 1874 */     int j = calendar.get(1);
/* 1875 */     int k = calendar.get(2);
/* 1876 */     calendar.setTimeInMillis(l2);
/* 1877 */     int m = calendar.get(1);
/* 1878 */     int n = calendar.get(2);
/* 1879 */     int i1 = m - j;
/* 1880 */     if (i == 2)
/* 1881 */       return (12 * i1 + n - k); 
/* 1882 */     if (i == 1) {
/* 1883 */       return i1;
/*      */     }
/* 1885 */     throw DbException.getUnsupportedException("DATEDIFF " + paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   private static String substring(String paramString, int paramInt1, int paramInt2) {
/* 1890 */     int i = paramString.length();
/* 1891 */     paramInt1--;
/* 1892 */     if (paramInt1 < 0) {
/* 1893 */       paramInt1 = 0;
/*      */     }
/* 1895 */     if (paramInt2 < 0) {
/* 1896 */       paramInt2 = 0;
/*      */     }
/* 1898 */     paramInt1 = (paramInt1 > i) ? i : paramInt1;
/* 1899 */     if (paramInt1 + paramInt2 > i) {
/* 1900 */       paramInt2 = i - paramInt1;
/*      */     }
/* 1902 */     return paramString.substring(paramInt1, paramInt1 + paramInt2);
/*      */   }
/*      */   
/*      */   private static String replace(String paramString1, String paramString2, String paramString3) {
/* 1906 */     if (paramString1 == null || paramString2 == null || paramString3 == null) {
/* 1907 */       return null;
/*      */     }
/* 1909 */     if (paramString2.length() == 0)
/*      */     {
/* 1911 */       return paramString1;
/*      */     }
/* 1913 */     StringBuilder stringBuilder = new StringBuilder(paramString1.length());
/* 1914 */     int i = 0;
/* 1915 */     int j = paramString2.length();
/*      */     while (true) {
/* 1917 */       int k = paramString1.indexOf(paramString2, i);
/* 1918 */       if (k == -1) {
/*      */         break;
/*      */       }
/* 1921 */       stringBuilder.append(paramString1.substring(i, k)).append(paramString3);
/* 1922 */       i = k + j;
/*      */     } 
/* 1924 */     stringBuilder.append(paramString1.substring(i));
/* 1925 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private static String repeat(String paramString, int paramInt) {
/* 1929 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() * paramInt);
/* 1930 */     while (paramInt-- > 0) {
/* 1931 */       stringBuilder.append(paramString);
/*      */     }
/* 1933 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private static String rawToHex(String paramString) {
/* 1937 */     int i = paramString.length();
/* 1938 */     StringBuilder stringBuilder = new StringBuilder(4 * i);
/* 1939 */     for (byte b = 0; b < i; b++) {
/* 1940 */       String str = Integer.toHexString(paramString.charAt(b) & Character.MAX_VALUE);
/* 1941 */       for (int j = str.length(); j < 4; j++) {
/* 1942 */         stringBuilder.append('0');
/*      */       }
/* 1944 */       stringBuilder.append(str);
/*      */     } 
/* 1946 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private static int locate(String paramString1, String paramString2, int paramInt) {
/* 1950 */     if (paramInt < 0) {
/* 1951 */       int i = paramString2.length() + paramInt;
/* 1952 */       return paramString2.lastIndexOf(paramString1, i) + 1;
/*      */     } 
/* 1954 */     boolean bool = (paramInt == 0) ? false : (paramInt - 1);
/* 1955 */     return paramString2.indexOf(paramString1, bool) + 1;
/*      */   }
/*      */   
/*      */   private static String right(String paramString, int paramInt) {
/* 1959 */     if (paramInt < 0) {
/* 1960 */       paramInt = 0;
/* 1961 */     } else if (paramInt > paramString.length()) {
/* 1962 */       paramInt = paramString.length();
/*      */     } 
/* 1964 */     return paramString.substring(paramString.length() - paramInt);
/*      */   }
/*      */   
/*      */   private static String left(String paramString, int paramInt) {
/* 1968 */     if (paramInt < 0) {
/* 1969 */       paramInt = 0;
/* 1970 */     } else if (paramInt > paramString.length()) {
/* 1971 */       paramInt = paramString.length();
/*      */     } 
/* 1973 */     return paramString.substring(0, paramInt);
/*      */   }
/*      */   
/*      */   private static String insert(String paramString1, int paramInt1, int paramInt2, String paramString2) {
/* 1977 */     if (paramString1 == null) {
/* 1978 */       return paramString2;
/*      */     }
/* 1980 */     if (paramString2 == null) {
/* 1981 */       return paramString1;
/*      */     }
/* 1983 */     int i = paramString1.length();
/* 1984 */     int j = paramString2.length();
/* 1985 */     paramInt1--;
/* 1986 */     if (paramInt1 < 0 || paramInt2 <= 0 || j == 0 || paramInt1 > i) {
/* 1987 */       return paramString1;
/*      */     }
/* 1989 */     if (paramInt1 + paramInt2 > i) {
/* 1990 */       paramInt2 = i - paramInt1;
/*      */     }
/* 1992 */     return paramString1.substring(0, paramInt1) + paramString2 + paramString1.substring(paramInt1 + paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   private static String hexToRaw(String paramString) {
/* 1997 */     int i = paramString.length();
/* 1998 */     if (i % 4 != 0) {
/* 1999 */       throw DbException.get(22018, paramString);
/*      */     }
/* 2001 */     StringBuilder stringBuilder = new StringBuilder(i / 4);
/* 2002 */     for (byte b = 0; b < i; b += 4) {
/*      */       try {
/* 2004 */         char c = (char)Integer.parseInt(paramString.substring(b, b + 4), 16);
/* 2005 */         stringBuilder.append(c);
/* 2006 */       } catch (NumberFormatException numberFormatException) {
/* 2007 */         throw DbException.get(22018, paramString);
/*      */       } 
/*      */     } 
/* 2010 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private static int getDifference(String paramString1, String paramString2) {
/* 2015 */     paramString1 = getSoundex(paramString1);
/* 2016 */     paramString2 = getSoundex(paramString2);
/* 2017 */     byte b1 = 0;
/* 2018 */     for (byte b2 = 0; b2 < 4; b2++) {
/* 2019 */       if (paramString1.charAt(b2) == paramString2.charAt(b2)) {
/* 2020 */         b1++;
/*      */       }
/*      */     } 
/* 2023 */     return b1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static String translate(String paramString1, String paramString2, String paramString3) {
/* 2028 */     if (StringUtils.isNullOrEmpty(paramString1) || StringUtils.isNullOrEmpty(paramString2))
/*      */     {
/* 2030 */       return paramString1;
/*      */     }
/*      */     
/* 2033 */     StringBuilder stringBuilder = null;
/*      */ 
/*      */     
/* 2036 */     byte b1 = (paramString3 == null) ? 0 : paramString3.length(); byte b2; int i;
/* 2037 */     for (b2 = 0, i = paramString1.length(); b2 < i; b2++) {
/* 2038 */       char c = paramString1.charAt(b2);
/* 2039 */       int j = paramString2.indexOf(c);
/* 2040 */       if (j >= 0) {
/* 2041 */         if (stringBuilder == null) {
/* 2042 */           stringBuilder = new StringBuilder(i);
/* 2043 */           if (b2 > 0) {
/* 2044 */             stringBuilder.append(paramString1.substring(0, b2));
/*      */           }
/*      */         } 
/* 2047 */         if (j < b1) {
/* 2048 */           c = paramString3.charAt(j);
/*      */         }
/*      */       } 
/* 2051 */       if (stringBuilder != null) {
/* 2052 */         stringBuilder.append(c);
/*      */       }
/*      */     } 
/* 2055 */     return (stringBuilder == null) ? paramString1 : stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private static double roundMagic(double paramDouble) {
/* 2059 */     if (paramDouble < 1.0E-13D && paramDouble > -1.0E-13D) {
/* 2060 */       return 0.0D;
/*      */     }
/* 2062 */     if (paramDouble > 1.0E12D || paramDouble < -1.0E12D) {
/* 2063 */       return paramDouble;
/*      */     }
/* 2065 */     StringBuilder stringBuilder = new StringBuilder();
/* 2066 */     stringBuilder.append(paramDouble);
/* 2067 */     if (stringBuilder.toString().indexOf('E') >= 0) {
/* 2068 */       return paramDouble;
/*      */     }
/* 2070 */     int i = stringBuilder.length();
/* 2071 */     if (i < 16) {
/* 2072 */       return paramDouble;
/*      */     }
/* 2074 */     if (stringBuilder.toString().indexOf('.') > i - 3) {
/* 2075 */       return paramDouble;
/*      */     }
/* 2077 */     stringBuilder.delete(i - 2, i);
/* 2078 */     i -= 2;
/* 2079 */     char c1 = stringBuilder.charAt(i - 2);
/* 2080 */     char c2 = stringBuilder.charAt(i - 3);
/* 2081 */     char c3 = stringBuilder.charAt(i - 4);
/* 2082 */     if (c1 == '0' && c2 == '0' && c3 == '0') {
/* 2083 */       stringBuilder.setCharAt(i - 1, '0');
/* 2084 */     } else if (c1 == '9' && c2 == '9' && c3 == '9') {
/* 2085 */       stringBuilder.setCharAt(i - 1, '9');
/* 2086 */       stringBuilder.append('9');
/* 2087 */       stringBuilder.append('9');
/* 2088 */       stringBuilder.append('9');
/*      */     } 
/* 2090 */     return Double.parseDouble(stringBuilder.toString());
/*      */   }
/*      */   
/*      */   private static String getSoundex(String paramString) {
/* 2094 */     int i = paramString.length();
/* 2095 */     char[] arrayOfChar = { '0', '0', '0', '0' };
/* 2096 */     byte b1 = 48;
/* 2097 */     for (byte b2 = 0, b3 = 0; b2 < i && b3 < 4; b2++) {
/* 2098 */       char c = paramString.charAt(b2);
/* 2099 */       byte b = (c > SOUNDEX_INDEX.length) ? 0 : SOUNDEX_INDEX[c];
/*      */       
/* 2101 */       if (b) {
/* 2102 */         if (b3 == 0) {
/* 2103 */           arrayOfChar[b3++] = c;
/* 2104 */           b1 = b;
/* 2105 */         } else if (b <= 54) {
/* 2106 */           if (b != b1) {
/* 2107 */             arrayOfChar[b3++] = b;
/* 2108 */             b1 = b;
/*      */           } 
/* 2110 */         } else if (b == 55) {
/* 2111 */           b1 = b;
/*      */         } 
/*      */       }
/*      */     } 
/* 2115 */     return new String(arrayOfChar);
/*      */   }
/*      */   
/*      */   private static Integer oraHash(String paramString, Integer paramInteger1, Integer paramInteger2) {
/* 2119 */     int i = paramString.hashCode();
/* 2120 */     if (paramInteger2 != null && paramInteger2.intValue() != 0) {
/* 2121 */       i *= paramInteger2.intValue() * 17;
/*      */     }
/* 2123 */     if (paramInteger1 != null && paramInteger1.intValue() > 0)
/*      */     {
/*      */       
/* 2126 */       i %= paramInteger1.intValue();
/*      */     }
/* 2128 */     return Integer.valueOf(i);
/*      */   }
/*      */   
/*      */   private static int makeRegexpFlags(String paramString) {
/* 2132 */     int i = 64;
/* 2133 */     if (paramString != null) {
/* 2134 */       for (byte b = 0; b < paramString.length(); b++) {
/* 2135 */         switch (paramString.charAt(b)) {
/*      */           case 'i':
/* 2137 */             i |= 0x2;
/*      */             break;
/*      */           case 'c':
/* 2140 */             i &= 0xFFFFFFFD;
/*      */             break;
/*      */           case 'n':
/* 2143 */             i |= 0x20;
/*      */             break;
/*      */           case 'm':
/* 2146 */             i |= 0x8;
/*      */             break;
/*      */           default:
/* 2149 */             throw DbException.get(90008, paramString);
/*      */         } 
/*      */       } 
/*      */     }
/* 2153 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getType() {
/* 2158 */     return this.dataType;
/*      */   }
/*      */ 
/*      */   
/*      */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 2163 */     for (Expression expression : this.args) {
/* 2164 */       if (expression != null) {
/* 2165 */         expression.mapColumns(paramColumnResolver, paramInt);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void checkParameterCount(int paramInt) {
/* 2177 */     byte b = 0; int i = Integer.MAX_VALUE;
/* 2178 */     switch (this.info.type) {
/*      */       case 204:
/*      */       case 210:
/*      */       case 219:
/*      */       case 220:
/* 2183 */         b = 1;
/*      */         break;
/*      */       case 20:
/*      */       case 112:
/*      */       case 119:
/* 2188 */         i = 1;
/*      */         break;
/*      */       case 21:
/*      */       case 27:
/*      */       case 32:
/*      */       case 63:
/*      */       case 69:
/*      */       case 78:
/*      */       case 88:
/*      */       case 97:
/*      */       case 225:
/* 2199 */         b = 1;
/* 2200 */         i = 2;
/*      */         break;
/*      */       case 93:
/*      */       case 96:
/* 2204 */         b = 1;
/* 2205 */         i = 3;
/*      */         break;
/*      */       case 95:
/* 2208 */         b = 1;
/* 2209 */         i = 3;
/*      */         break;
/*      */       case 58:
/*      */       case 62:
/*      */       case 67:
/*      */       case 72:
/*      */       case 73:
/*      */       case 90:
/*      */       case 91:
/* 2218 */         b = 2;
/* 2219 */         i = 3;
/*      */         break;
/*      */       case 54:
/*      */       case 92:
/*      */       case 211:
/* 2224 */         b = 2;
/*      */         break;
/*      */       case 84:
/* 2227 */         b = 1;
/* 2228 */         i = 4;
/*      */         break;
/*      */       case 121:
/*      */       case 122:
/* 2232 */         b = 2;
/* 2233 */         i = 4;
/*      */         break;
/*      */       case 207:
/*      */       case 208:
/* 2237 */         b = 1;
/* 2238 */         i = 2;
/*      */         break;
/*      */       case 206:
/*      */       case 229:
/* 2242 */         b = 3;
/*      */         break;
/*      */       case 89:
/* 2245 */         b = 3;
/* 2246 */         i = 4;
/*      */         break;
/*      */       case 240:
/* 2249 */         b = 2;
/* 2250 */         i = 3;
/*      */         break;
/*      */       default:
/* 2253 */         DbException.throwInternalError("type=" + this.info.type); break;
/*      */     } 
/* 2255 */     boolean bool = (paramInt >= b && paramInt <= i) ? true : false;
/* 2256 */     if (!bool) {
/* 2257 */       throw DbException.get(7001, new String[] { this.info.name, b + ".." + i });
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
/*      */   
/*      */   public void doneWithParameters() {
/* 2270 */     if (this.info.parameterCount == -1) {
/* 2271 */       int i = this.varArgs.size();
/* 2272 */       checkParameterCount(i);
/* 2273 */       this.args = new Expression[i];
/* 2274 */       this.varArgs.toArray(this.args);
/* 2275 */       this.varArgs = null;
/*      */     } else {
/* 2277 */       int i = this.args.length;
/* 2278 */       if (i > 0 && this.args[i - 1] == null) {
/* 2279 */         throw DbException.get(7001, new String[] { this.info.name, "" + i });
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDataType(Column paramColumn)
/*      */   {
/* 2287 */     this.dataType = paramColumn.getType();
/* 2288 */     this.precision = paramColumn.getPrecision();
/* 2289 */     this.displaySize = paramColumn.getDisplaySize();
/* 2290 */     this.scale = paramColumn.getScale(); } public Expression optimize(Session paramSession) { int j, k; long l;
/*      */     byte b;
/*      */     Expression expression2;
/*      */     DataType dataType;
/*      */     int m;
/* 2295 */     boolean bool = this.info.deterministic; int i;
/* 2296 */     for (i = 0; i < this.args.length; i++) {
/* 2297 */       Expression expression = this.args[i];
/* 2298 */       if (expression != null) {
/*      */ 
/*      */         
/* 2301 */         expression = expression.optimize(paramSession);
/* 2302 */         this.args[i] = expression;
/* 2303 */         if (!expression.isConstant()) {
/* 2304 */           bool = false;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2309 */     Expression expression1 = (this.args.length < 1) ? null : this.args[0];
/* 2310 */     switch (this.info.type) {
/*      */       case 200:
/*      */       case 204:
/*      */       case 205:
/*      */       case 219:
/*      */       case 220:
/* 2316 */         i = -1;
/* 2317 */         j = 0;
/* 2318 */         l = 0L;
/* 2319 */         k = 0;
/* 2320 */         for (Expression expression : this.args) {
/* 2321 */           if (expression != ValueExpression.getNull()) {
/* 2322 */             int n = expression.getType();
/* 2323 */             if (n != -1 && n != 0) {
/* 2324 */               i = Value.getHigherOrder(i, n);
/* 2325 */               j = Math.max(j, expression.getScale());
/* 2326 */               l = Math.max(l, expression.getPrecision());
/* 2327 */               k = Math.max(k, expression.getDisplaySize());
/*      */             } 
/*      */           } 
/*      */         } 
/* 2331 */         if (i == -1) {
/* 2332 */           i = 13;
/* 2333 */           j = 0;
/* 2334 */           l = 2147483647L;
/* 2335 */           k = Integer.MAX_VALUE;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 206:
/*      */       case 229:
/* 2341 */         i = -1;
/* 2342 */         j = 0;
/* 2343 */         l = 0L;
/* 2344 */         k = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2349 */         for (b = 2, m = this.args.length; b < m; b += 2) {
/* 2350 */           Expression expression = this.args[b];
/* 2351 */           if (expression != ValueExpression.getNull()) {
/* 2352 */             int n = expression.getType();
/* 2353 */             if (n != -1 && n != 0) {
/* 2354 */               i = Value.getHigherOrder(i, n);
/* 2355 */               j = Math.max(j, expression.getScale());
/* 2356 */               l = Math.max(l, expression.getPrecision());
/* 2357 */               k = Math.max(k, expression.getDisplaySize());
/*      */             } 
/*      */           } 
/*      */         } 
/* 2361 */         if (this.args.length % 2 == 0) {
/* 2362 */           Expression expression = this.args[this.args.length - 1];
/* 2363 */           if (expression != ValueExpression.getNull()) {
/* 2364 */             m = expression.getType();
/* 2365 */             if (m != -1 && m != 0) {
/* 2366 */               i = Value.getHigherOrder(i, m);
/* 2367 */               j = Math.max(j, expression.getScale());
/* 2368 */               l = Math.max(l, expression.getPrecision());
/* 2369 */               k = Math.max(k, expression.getDisplaySize());
/*      */             } 
/*      */           } 
/*      */         } 
/* 2373 */         if (i == -1) {
/* 2374 */           i = 13;
/* 2375 */           j = 0;
/* 2376 */           l = 2147483647L;
/* 2377 */           k = Integer.MAX_VALUE;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 201:
/* 2382 */         i = Value.getHigherOrder(this.args[1].getType(), this.args[2].getType());
/* 2383 */         l = Math.max(this.args[1].getPrecision(), this.args[2].getPrecision());
/* 2384 */         k = Math.max(this.args[1].getDisplaySize(), this.args[2].getDisplaySize());
/* 2385 */         j = Math.max(this.args[1].getScale(), this.args[2].getScale());
/*      */         break;
/*      */       case 228:
/* 2388 */         switch (this.args[1].getType()) {
/*      */           case 13:
/*      */           case 14:
/*      */           case 16:
/*      */           case 21:
/* 2393 */             i = this.args[1].getType();
/*      */             break;
/*      */           default:
/* 2396 */             i = Value.getHigherOrder(this.args[1].getType(), this.args[2].getType());
/*      */             break;
/*      */         } 
/* 2399 */         l = Math.max(this.args[1].getPrecision(), this.args[2].getPrecision());
/* 2400 */         k = Math.max(this.args[1].getDisplaySize(), this.args[2].getDisplaySize());
/* 2401 */         j = Math.max(this.args[1].getScale(), this.args[2].getScale());
/*      */         break;
/*      */       
/*      */       case 202:
/*      */       case 203:
/*      */       case 227:
/* 2407 */         i = this.dataType;
/* 2408 */         l = this.precision;
/* 2409 */         j = this.scale;
/* 2410 */         k = this.displaySize;
/*      */         break;
/*      */       case 27:
/* 2413 */         i = expression1.getType();
/* 2414 */         j = expression1.getScale();
/* 2415 */         l = expression1.getPrecision();
/* 2416 */         k = expression1.getDisplaySize();
/* 2417 */         if (i == 0) {
/* 2418 */           i = 4;
/* 2419 */           l = 10L;
/* 2420 */           k = 11;
/* 2421 */           j = 0; break;
/* 2422 */         }  if (i == 11) {
/* 2423 */           i = 10;
/* 2424 */           l = 8L;
/* 2425 */           j = 0;
/* 2426 */           k = 10;
/*      */         } 
/*      */         break;
/*      */       case 0:
/*      */       case 13:
/*      */       case 21:
/* 2432 */         i = expression1.getType();
/* 2433 */         j = expression1.getScale();
/* 2434 */         l = expression1.getPrecision();
/* 2435 */         k = expression1.getDisplaySize();
/* 2436 */         if (i == 0) {
/* 2437 */           i = 4;
/* 2438 */           l = 10L;
/* 2439 */           k = 11;
/* 2440 */           j = 0;
/*      */         } 
/*      */         break;
/*      */       case 222:
/* 2444 */         expression2 = this.args[1];
/* 2445 */         i = expression2.getType();
/* 2446 */         l = expression2.getPrecision();
/* 2447 */         j = expression2.getScale();
/* 2448 */         k = expression2.getDisplaySize();
/* 2449 */         if (!(expression1 instanceof Variable)) {
/* 2450 */           throw DbException.get(90137, expression1.getSQL());
/*      */         }
/*      */         break;
/*      */ 
/*      */       
/*      */       case 225:
/* 2456 */         if (this.args.length == 1) {
/* 2457 */           i = 15;
/*      */         } else {
/* 2459 */           i = 16;
/*      */         } 
/* 2461 */         l = 2147483647L;
/* 2462 */         j = 0;
/* 2463 */         k = Integer.MAX_VALUE;
/*      */         break;
/*      */       
/*      */       case 72:
/*      */       case 73:
/* 2468 */         i = this.info.dataType;
/* 2469 */         l = this.args[0].getPrecision();
/* 2470 */         j = 0;
/* 2471 */         if (this.args[1].isConstant())
/*      */         {
/*      */           
/* 2474 */           l -= this.args[1].getValue(paramSession).getLong() - 1L;
/*      */         }
/* 2476 */         if (this.args.length == 3 && this.args[2].isConstant())
/*      */         {
/* 2478 */           l = Math.min(l, this.args[2].getValue(paramSession).getLong());
/*      */         }
/* 2480 */         l = Math.max(0L, l);
/* 2481 */         k = MathUtils.convertLongToInt(l);
/*      */         break;
/*      */       
/*      */       default:
/* 2485 */         i = this.info.dataType;
/* 2486 */         dataType = DataType.getDataType(i);
/* 2487 */         l = -1L;
/* 2488 */         k = 0;
/* 2489 */         j = dataType.defaultScale; break;
/*      */     } 
/* 2491 */     this.dataType = i;
/* 2492 */     this.precision = l;
/* 2493 */     this.scale = j;
/* 2494 */     this.displaySize = k;
/* 2495 */     if (bool) {
/* 2496 */       Value value = getValue(paramSession);
/* 2497 */       if (value == ValueNull.INSTANCE && (
/* 2498 */         this.info.type == 203 || this.info.type == 202)) {
/* 2499 */         return this;
/*      */       }
/*      */       
/* 2502 */       return ValueExpression.get(value);
/*      */     } 
/* 2504 */     return this; }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 2509 */     for (Expression expression : this.args) {
/* 2510 */       if (expression != null) {
/* 2511 */         expression.setEvaluatable(paramTableFilter, paramBoolean);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getScale() {
/* 2518 */     return this.scale;
/*      */   }
/*      */ 
/*      */   
/*      */   public long getPrecision() {
/* 2523 */     if (this.precision == -1L) {
/* 2524 */       calculatePrecisionAndDisplaySize();
/*      */     }
/* 2526 */     return this.precision;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getDisplaySize() {
/* 2531 */     if (this.precision == -1L) {
/* 2532 */       calculatePrecisionAndDisplaySize();
/*      */     }
/* 2534 */     return this.displaySize;
/*      */   }
/*      */   
/*      */   private void calculatePrecisionAndDisplaySize() {
/* 2538 */     switch (this.info.type) {
/*      */       case 30:
/*      */       case 31:
/* 2541 */         this.precision = this.args[2].getPrecision();
/* 2542 */         this.displaySize = this.args[2].getDisplaySize();
/*      */         return;
/*      */       case 32:
/* 2545 */         this.precision = this.args[0].getPrecision();
/* 2546 */         this.displaySize = this.args[0].getDisplaySize();
/*      */         return;
/*      */       case 52:
/* 2549 */         this.precision = 1L;
/* 2550 */         this.displaySize = 1;
/*      */         return;
/*      */       case 54:
/* 2553 */         this.precision = 0L;
/* 2554 */         this.displaySize = 0;
/* 2555 */         for (Expression expression : this.args) {
/* 2556 */           this.precision += expression.getPrecision();
/* 2557 */           this.displaySize = MathUtils.convertLongToInt(this.displaySize + expression.getDisplaySize());
/*      */           
/* 2559 */           if (this.precision < 0L) {
/* 2560 */             this.precision = Long.MAX_VALUE;
/*      */           }
/*      */         } 
/*      */         return;
/*      */       case 56:
/* 2565 */         this.precision = (this.args[0].getPrecision() + 3L) / 4L;
/* 2566 */         this.displaySize = MathUtils.convertLongToInt(this.precision);
/*      */         return;
/*      */       case 27:
/*      */       case 59:
/*      */       case 63:
/*      */       case 68:
/*      */       case 69:
/*      */       case 74:
/*      */       case 75:
/*      */       case 76:
/*      */       case 78:
/*      */       case 80:
/*      */       case 82:
/* 2579 */         this.precision = this.args[0].getPrecision();
/* 2580 */         this.displaySize = this.args[0].getDisplaySize();
/*      */         return;
/*      */       case 65:
/* 2583 */         this.precision = this.args[0].getPrecision() * 4L;
/* 2584 */         this.displaySize = MathUtils.convertLongToInt(this.precision);
/*      */         return;
/*      */       case 70:
/* 2587 */         this.precision = 4L;
/* 2588 */         this.displaySize = (int)this.precision;
/*      */         return;
/*      */       
/*      */       case 104:
/*      */       case 111:
/* 2593 */         this.precision = 20L;
/* 2594 */         this.displaySize = (int)this.precision;
/*      */         return;
/*      */     } 
/* 2597 */     DataType dataType = DataType.getDataType(this.dataType);
/* 2598 */     this.precision = dataType.defaultPrecision;
/* 2599 */     this.displaySize = dataType.defaultDisplaySize;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getSQL() {
/*      */     ValueString valueString;
/* 2605 */     StatementBuilder statementBuilder = new StatementBuilder(this.info.name);
/* 2606 */     if (this.info.type == 206) {
/* 2607 */       if (this.args[0] != null)
/* 2608 */         statementBuilder.append(" ").append(this.args[0].getSQL());  byte b;
/*      */       int i;
/* 2610 */       for (b = 1, i = this.args.length - 1; b < i; b += 2) {
/* 2611 */         statementBuilder.append(" WHEN ").append(this.args[b].getSQL());
/* 2612 */         statementBuilder.append(" THEN ").append(this.args[b + 1].getSQL());
/*      */       } 
/* 2614 */       if (this.args.length % 2 == 0) {
/* 2615 */         statementBuilder.append(" ELSE ").append(this.args[this.args.length - 1].getSQL());
/*      */       }
/* 2617 */       return statementBuilder.append(" END").toString();
/*      */     } 
/* 2619 */     statementBuilder.append('(');
/* 2620 */     switch (this.info.type)
/*      */     { case 203:
/* 2622 */         statementBuilder.append(this.args[0].getSQL()).append(" AS ").append((new Column(null, this.dataType, this.precision, this.scale, this.displaySize)).getCreateSQL());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2651 */         return statementBuilder.append(')').toString();case 202: if ((this.database.getMode()).swapConvertFunctionParameters) { statementBuilder.append((new Column(null, this.dataType, this.precision, this.scale, this.displaySize)).getCreateSQL()).append(',').append(this.args[0].getSQL()); } else { statementBuilder.append(this.args[0].getSQL()).append(',').append((new Column(null, this.dataType, this.precision, this.scale, this.displaySize)).getCreateSQL()); }  return statementBuilder.append(')').toString();case 120: valueString = (ValueString)((ValueExpression)this.args[0]).getValue(null); statementBuilder.append(valueString.getString()).append(" FROM ").append(this.args[1].getSQL()); return statementBuilder.append(')').toString(); }  for (Expression expression : this.args) { statementBuilder.appendExceptFirst(", "); statementBuilder.append(expression.getSQL()); }  return statementBuilder.append(')').toString();
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateAggregate(Session paramSession) {
/* 2656 */     for (Expression expression : this.args) {
/* 2657 */       if (expression != null) {
/* 2658 */         expression.updateAggregate(paramSession);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getFunctionType() {
/* 2664 */     return this.info.type;
/*      */   }
/*      */   
/*      */   public String getName()
/*      */   {
/* 2669 */     return this.info.name; } public ValueResultSet getValueForColumnList(Session paramSession, Expression[] paramArrayOfExpression) { String str1; String str2; Csv csv; String str3;
/*      */     String str4;
/*      */     char c;
/*      */     String[] arrayOfString;
/*      */     ResultSet resultSet;
/*      */     ValueResultSet valueResultSet;
/* 2675 */     switch (this.info.type) {
/*      */       case 210:
/* 2677 */         str1 = paramArrayOfExpression[0].getValue(paramSession).getString();
/* 2678 */         if (str1 == null) {
/* 2679 */           throw DbException.get(90012, "fileName");
/*      */         }
/* 2681 */         str2 = (paramArrayOfExpression.length < 2) ? null : paramArrayOfExpression[1].getValue(paramSession).getString();
/*      */         
/* 2683 */         csv = new Csv();
/* 2684 */         str3 = (paramArrayOfExpression.length < 3) ? null : paramArrayOfExpression[2].getValue(paramSession).getString();
/*      */         
/* 2686 */         str4 = null;
/* 2687 */         if (str3 != null && str3.indexOf('=') >= 0) {
/* 2688 */           str4 = csv.setOptions(str3);
/*      */         } else {
/* 2690 */           str4 = str3;
/* 2691 */           String str5 = (paramArrayOfExpression.length < 4) ? null : paramArrayOfExpression[3].getValue(paramSession).getString();
/*      */           
/* 2693 */           String str6 = (paramArrayOfExpression.length < 5) ? null : paramArrayOfExpression[4].getValue(paramSession).getString();
/*      */           
/* 2695 */           String str7 = (paramArrayOfExpression.length < 6) ? null : paramArrayOfExpression[5].getValue(paramSession).getString();
/*      */           
/* 2697 */           setCsvDelimiterEscape(csv, str5, str6, str7);
/*      */         } 
/*      */         
/* 2700 */         c = csv.getFieldSeparatorRead();
/* 2701 */         arrayOfString = StringUtils.arraySplit(str2, c, true);
/* 2702 */         resultSet = null;
/*      */         
/*      */         try {
/* 2705 */           resultSet = csv.read(str1, arrayOfString, str4);
/* 2706 */           valueResultSet = ValueResultSet.getCopy(resultSet, 0);
/* 2707 */         } catch (SQLException sQLException) {
/* 2708 */           throw DbException.convert(sQLException);
/*      */         } finally {
/* 2710 */           csv.close();
/* 2711 */           JdbcUtils.closeSilently(resultSet);
/*      */         } 
/* 2713 */         return valueResultSet;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2718 */     return (ValueResultSet)getValueWithArgs(paramSession, paramArrayOfExpression); }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void setCsvDelimiterEscape(Csv paramCsv, String paramString1, String paramString2, String paramString3) {
/* 2723 */     if (paramString1 != null) {
/* 2724 */       paramCsv.setFieldSeparatorWrite(paramString1);
/* 2725 */       if (paramString1.length() > 0) {
/* 2726 */         char c = paramString1.charAt(0);
/* 2727 */         paramCsv.setFieldSeparatorRead(c);
/*      */       } 
/*      */     } 
/* 2730 */     if (paramString2 != null) {
/* 2731 */       boolean bool = (paramString2.length() == 0) ? false : paramString2.charAt(0);
/*      */       
/* 2733 */       paramCsv.setFieldDelimiter(bool);
/*      */     } 
/* 2735 */     if (paramString3 != null) {
/* 2736 */       boolean bool = (paramString3.length() == 0) ? false : paramString3.charAt(0);
/*      */       
/* 2738 */       paramCsv.setEscapeCharacter(bool);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Expression[] getArgs() {
/* 2744 */     return this.args;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 2749 */     for (Expression expression : this.args) {
/* 2750 */       if (expression != null && !expression.isEverything(paramExpressionVisitor)) {
/* 2751 */         return false;
/*      */       }
/*      */     } 
/* 2754 */     switch (paramExpressionVisitor.getType()) {
/*      */       case 2:
/*      */       case 5:
/*      */       case 8:
/* 2758 */         return this.info.deterministic;
/*      */       case 0:
/*      */       case 1:
/*      */       case 3:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/* 2766 */         return true;
/*      */     } 
/* 2768 */     throw DbException.throwInternalError("type=" + paramExpressionVisitor.getType());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCost() {
/* 2774 */     int i = 3;
/* 2775 */     for (Expression expression : this.args) {
/* 2776 */       if (expression != null) {
/* 2777 */         i += expression.getCost();
/*      */       }
/*      */     } 
/* 2780 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isDeterministic() {
/* 2785 */     return this.info.deterministic;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isBufferResultSetToLocalTemp() {
/* 2790 */     return this.info.bufferResultSetToLocalTemp;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\Function.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */