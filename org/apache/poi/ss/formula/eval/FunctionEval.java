/*     */ package org.apache.poi.ss.formula.eval;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.poi.ss.formula.function.FunctionMetadata;
/*     */ import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
/*     */ import org.apache.poi.ss.formula.functions.Address;
/*     */ import org.apache.poi.ss.formula.functions.AggregateFunction;
/*     */ import org.apache.poi.ss.formula.functions.BooleanFunction;
/*     */ import org.apache.poi.ss.formula.functions.CalendarFieldFunction;
/*     */ import org.apache.poi.ss.formula.functions.Choose;
/*     */ import org.apache.poi.ss.formula.functions.Code;
/*     */ import org.apache.poi.ss.formula.functions.Columns;
/*     */ import org.apache.poi.ss.formula.functions.Counta;
/*     */ import org.apache.poi.ss.formula.functions.Countblank;
/*     */ import org.apache.poi.ss.formula.functions.Countif;
/*     */ import org.apache.poi.ss.formula.functions.DStarRunner;
/*     */ import org.apache.poi.ss.formula.functions.Errortype;
/*     */ import org.apache.poi.ss.formula.functions.FinanceFunction;
/*     */ import org.apache.poi.ss.formula.functions.Fixed;
/*     */ import org.apache.poi.ss.formula.functions.Function;
/*     */ import org.apache.poi.ss.formula.functions.Hlookup;
/*     */ import org.apache.poi.ss.formula.functions.Hyperlink;
/*     */ import org.apache.poi.ss.formula.functions.IPMT;
/*     */ import org.apache.poi.ss.formula.functions.IfFunc;
/*     */ import org.apache.poi.ss.formula.functions.Index;
/*     */ import org.apache.poi.ss.formula.functions.LogicalFunction;
/*     */ import org.apache.poi.ss.formula.functions.Match;
/*     */ import org.apache.poi.ss.formula.functions.MinaMaxa;
/*     */ import org.apache.poi.ss.formula.functions.Mirr;
/*     */ import org.apache.poi.ss.formula.functions.Na;
/*     */ import org.apache.poi.ss.formula.functions.Now;
/*     */ import org.apache.poi.ss.formula.functions.NumericFunction;
/*     */ import org.apache.poi.ss.formula.functions.Odd;
/*     */ import org.apache.poi.ss.formula.functions.Offset;
/*     */ import org.apache.poi.ss.formula.functions.PPMT;
/*     */ import org.apache.poi.ss.formula.functions.Rank;
/*     */ import org.apache.poi.ss.formula.functions.Rate;
/*     */ import org.apache.poi.ss.formula.functions.Rept;
/*     */ import org.apache.poi.ss.formula.functions.Roman;
/*     */ import org.apache.poi.ss.formula.functions.Rows;
/*     */ import org.apache.poi.ss.formula.functions.Slope;
/*     */ import org.apache.poi.ss.formula.functions.Substitute;
/*     */ import org.apache.poi.ss.formula.functions.Subtotal;
/*     */ import org.apache.poi.ss.formula.functions.Sumif;
/*     */ import org.apache.poi.ss.formula.functions.Sumproduct;
/*     */ import org.apache.poi.ss.formula.functions.Sumx2my2;
/*     */ import org.apache.poi.ss.formula.functions.Sumx2py2;
/*     */ import org.apache.poi.ss.formula.functions.Sumxmy2;
/*     */ import org.apache.poi.ss.formula.functions.T;
/*     */ import org.apache.poi.ss.formula.functions.TextFunction;
/*     */ import org.apache.poi.ss.formula.functions.TimeFunc;
/*     */ import org.apache.poi.ss.formula.functions.Today;
/*     */ import org.apache.poi.ss.formula.functions.Value;
/*     */ import org.apache.poi.ss.formula.functions.Vlookup;
/*     */ import org.apache.poi.ss.formula.functions.WeekdayFunc;
/*     */ 
/*     */ public final class FunctionEval {
/*  59 */   protected static final Function[] functions = produceFunctions();
/*     */   private static final class FunctionID {
/*     */     public static final int IF = 1; public static final int SUM = 4; public static final int OFFSET = 78; public static final int CHOOSE = 100;
/*     */     public static final int INDIRECT = 148;
/*     */     public static final int EXTERNAL_FUNC = 255; }
/*     */   
/*     */   private static Function[] produceFunctions() {
/*  66 */     Function[] arrayOfFunction = new Function[368];
/*     */     
/*  68 */     arrayOfFunction[0] = (Function)new Count();
/*  69 */     arrayOfFunction[1] = (Function)new IfFunc();
/*  70 */     arrayOfFunction[2] = LogicalFunction.ISNA;
/*  71 */     arrayOfFunction[3] = LogicalFunction.ISERROR;
/*  72 */     arrayOfFunction[4] = AggregateFunction.SUM;
/*  73 */     arrayOfFunction[5] = AggregateFunction.AVERAGE;
/*  74 */     arrayOfFunction[6] = AggregateFunction.MIN;
/*  75 */     arrayOfFunction[7] = AggregateFunction.MAX;
/*  76 */     arrayOfFunction[8] = (Function)new RowFunc();
/*  77 */     arrayOfFunction[9] = (Function)new Column();
/*  78 */     arrayOfFunction[10] = (Function)new Na();
/*  79 */     arrayOfFunction[11] = (Function)new Npv();
/*  80 */     arrayOfFunction[12] = AggregateFunction.STDEV;
/*  81 */     arrayOfFunction[13] = NumericFunction.DOLLAR;
/*  82 */     arrayOfFunction[14] = (Function)new Fixed();
/*  83 */     arrayOfFunction[15] = NumericFunction.SIN;
/*  84 */     arrayOfFunction[16] = NumericFunction.COS;
/*  85 */     arrayOfFunction[17] = NumericFunction.TAN;
/*  86 */     arrayOfFunction[18] = NumericFunction.ATAN;
/*  87 */     arrayOfFunction[19] = NumericFunction.PI;
/*  88 */     arrayOfFunction[20] = NumericFunction.SQRT;
/*  89 */     arrayOfFunction[21] = NumericFunction.EXP;
/*  90 */     arrayOfFunction[22] = NumericFunction.LN;
/*  91 */     arrayOfFunction[23] = NumericFunction.LOG10;
/*  92 */     arrayOfFunction[24] = NumericFunction.ABS;
/*  93 */     arrayOfFunction[25] = NumericFunction.INT;
/*  94 */     arrayOfFunction[26] = NumericFunction.SIGN;
/*  95 */     arrayOfFunction[27] = NumericFunction.ROUND;
/*  96 */     arrayOfFunction[28] = (Function)new Lookup();
/*  97 */     arrayOfFunction[29] = (Function)new Index();
/*  98 */     arrayOfFunction[30] = (Function)new Rept();
/*  99 */     arrayOfFunction[31] = TextFunction.MID;
/* 100 */     arrayOfFunction[32] = TextFunction.LEN;
/* 101 */     arrayOfFunction[33] = (Function)new Value();
/* 102 */     arrayOfFunction[34] = BooleanFunction.TRUE;
/* 103 */     arrayOfFunction[35] = BooleanFunction.FALSE;
/* 104 */     arrayOfFunction[36] = BooleanFunction.AND;
/* 105 */     arrayOfFunction[37] = BooleanFunction.OR;
/* 106 */     arrayOfFunction[38] = BooleanFunction.NOT;
/* 107 */     arrayOfFunction[39] = NumericFunction.MOD;
/*     */ 
/*     */ 
/*     */     
/* 111 */     arrayOfFunction[43] = (Function)new DStarRunner(DStarRunner.DStarAlgorithmEnum.DMIN);
/*     */ 
/*     */     
/* 114 */     arrayOfFunction[46] = AggregateFunction.VAR;
/*     */     
/* 116 */     arrayOfFunction[48] = TextFunction.TEXT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     arrayOfFunction[56] = FinanceFunction.PV;
/* 123 */     arrayOfFunction[57] = FinanceFunction.FV;
/* 124 */     arrayOfFunction[58] = FinanceFunction.NPER;
/* 125 */     arrayOfFunction[59] = FinanceFunction.PMT;
/* 126 */     arrayOfFunction[60] = (Function)new Rate();
/* 127 */     arrayOfFunction[61] = (Function)new Mirr();
/* 128 */     arrayOfFunction[62] = (Function)new Irr();
/* 129 */     arrayOfFunction[63] = NumericFunction.RAND;
/* 130 */     arrayOfFunction[64] = (Function)new Match();
/* 131 */     arrayOfFunction[65] = DateFunc.instance;
/* 132 */     arrayOfFunction[66] = (Function)new TimeFunc();
/* 133 */     arrayOfFunction[67] = CalendarFieldFunction.DAY;
/* 134 */     arrayOfFunction[68] = CalendarFieldFunction.MONTH;
/* 135 */     arrayOfFunction[69] = CalendarFieldFunction.YEAR;
/* 136 */     arrayOfFunction[70] = WeekdayFunc.instance;
/* 137 */     arrayOfFunction[71] = CalendarFieldFunction.HOUR;
/* 138 */     arrayOfFunction[72] = CalendarFieldFunction.MINUTE;
/* 139 */     arrayOfFunction[73] = CalendarFieldFunction.SECOND;
/* 140 */     arrayOfFunction[74] = (Function)new Now();
/*     */     
/* 142 */     arrayOfFunction[76] = (Function)new Rows();
/* 143 */     arrayOfFunction[77] = (Function)new Columns();
/* 144 */     arrayOfFunction[78] = (Function)new Offset();
/*     */     
/* 146 */     arrayOfFunction[82] = TextFunction.SEARCH;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     arrayOfFunction[97] = NumericFunction.ATAN2;
/* 152 */     arrayOfFunction[98] = NumericFunction.ASIN;
/* 153 */     arrayOfFunction[99] = NumericFunction.ACOS;
/* 154 */     arrayOfFunction[100] = (Function)new Choose();
/* 155 */     arrayOfFunction[101] = (Function)new Hlookup();
/* 156 */     arrayOfFunction[102] = (Function)new Vlookup();
/*     */     
/* 158 */     arrayOfFunction[105] = LogicalFunction.ISREF;
/*     */     
/* 160 */     arrayOfFunction[109] = NumericFunction.LOG;
/*     */     
/* 162 */     arrayOfFunction[111] = TextFunction.CHAR;
/* 163 */     arrayOfFunction[112] = TextFunction.LOWER;
/* 164 */     arrayOfFunction[113] = TextFunction.UPPER;
/* 165 */     arrayOfFunction[114] = TextFunction.PROPER;
/* 166 */     arrayOfFunction[115] = TextFunction.LEFT;
/* 167 */     arrayOfFunction[116] = TextFunction.RIGHT;
/* 168 */     arrayOfFunction[117] = TextFunction.EXACT;
/* 169 */     arrayOfFunction[118] = TextFunction.TRIM;
/* 170 */     arrayOfFunction[119] = (Function)new Replace();
/* 171 */     arrayOfFunction[120] = (Function)new Substitute();
/* 172 */     arrayOfFunction[121] = (Function)new Code();
/*     */     
/* 174 */     arrayOfFunction[124] = TextFunction.FIND;
/*     */     
/* 176 */     arrayOfFunction[126] = LogicalFunction.ISERR;
/* 177 */     arrayOfFunction[127] = LogicalFunction.ISTEXT;
/* 178 */     arrayOfFunction[128] = LogicalFunction.ISNUMBER;
/* 179 */     arrayOfFunction[129] = LogicalFunction.ISBLANK;
/* 180 */     arrayOfFunction[130] = (Function)new T();
/*     */     
/* 182 */     arrayOfFunction[148] = null;
/*     */     
/* 184 */     arrayOfFunction[162] = TextFunction.CLEAN;
/*     */     
/* 186 */     arrayOfFunction[167] = (Function)new IPMT();
/* 187 */     arrayOfFunction[168] = (Function)new PPMT();
/* 188 */     arrayOfFunction[169] = (Function)new Counta();
/*     */     
/* 190 */     arrayOfFunction[183] = AggregateFunction.PRODUCT;
/* 191 */     arrayOfFunction[184] = NumericFunction.FACT;
/*     */     
/* 193 */     arrayOfFunction[190] = LogicalFunction.ISNONTEXT;
/*     */     
/* 195 */     arrayOfFunction[194] = AggregateFunction.VARP;
/*     */     
/* 197 */     arrayOfFunction[197] = NumericFunction.TRUNC;
/* 198 */     arrayOfFunction[198] = LogicalFunction.ISLOGICAL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 208 */     arrayOfFunction[212] = NumericFunction.ROUNDUP;
/* 209 */     arrayOfFunction[213] = NumericFunction.ROUNDDOWN;
/*     */ 
/*     */     
/* 212 */     arrayOfFunction[216] = (Function)new Rank();
/* 213 */     arrayOfFunction[219] = (Function)new Address();
/* 214 */     arrayOfFunction[220] = (Function)new Days360();
/* 215 */     arrayOfFunction[221] = (Function)new Today();
/*     */ 
/*     */     
/* 218 */     arrayOfFunction[227] = AggregateFunction.MEDIAN;
/* 219 */     arrayOfFunction[228] = (Function)new Sumproduct();
/* 220 */     arrayOfFunction[229] = NumericFunction.SINH;
/* 221 */     arrayOfFunction[230] = NumericFunction.COSH;
/* 222 */     arrayOfFunction[231] = NumericFunction.TANH;
/* 223 */     arrayOfFunction[232] = NumericFunction.ASINH;
/* 224 */     arrayOfFunction[233] = NumericFunction.ACOSH;
/* 225 */     arrayOfFunction[234] = NumericFunction.ATANH;
/* 226 */     arrayOfFunction[235] = (Function)new DStarRunner(DStarRunner.DStarAlgorithmEnum.DGET);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 232 */     arrayOfFunction[255] = null;
/*     */     
/* 234 */     arrayOfFunction[261] = (Function)new Errortype();
/*     */     
/* 236 */     arrayOfFunction[269] = AggregateFunction.AVEDEV;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 243 */     arrayOfFunction[276] = NumericFunction.COMBIN;
/*     */ 
/*     */     
/* 246 */     arrayOfFunction[279] = (Function)new Even();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 252 */     arrayOfFunction[285] = NumericFunction.FLOOR;
/*     */ 
/*     */     
/* 255 */     arrayOfFunction[288] = NumericFunction.CEILING;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 265 */     arrayOfFunction[298] = (Function)new Odd();
/*     */     
/* 267 */     arrayOfFunction[300] = NumericFunction.POISSON;
/*     */ 
/*     */     
/* 270 */     arrayOfFunction[303] = (Function)new Sumxmy2();
/* 271 */     arrayOfFunction[304] = (Function)new Sumx2my2();
/* 272 */     arrayOfFunction[305] = (Function)new Sumx2py2();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 278 */     arrayOfFunction[311] = (Function)new Intercept();
/*     */ 
/*     */ 
/*     */     
/* 282 */     arrayOfFunction[315] = (Function)new Slope();
/*     */ 
/*     */     
/* 285 */     arrayOfFunction[318] = AggregateFunction.DEVSQ;
/*     */ 
/*     */     
/* 288 */     arrayOfFunction[321] = AggregateFunction.SUMSQ;
/*     */ 
/*     */ 
/*     */     
/* 292 */     arrayOfFunction[325] = AggregateFunction.LARGE;
/* 293 */     arrayOfFunction[326] = AggregateFunction.SMALL;
/*     */     
/* 295 */     arrayOfFunction[328] = AggregateFunction.PERCENTILE;
/*     */     
/* 297 */     arrayOfFunction[330] = (Function)new Mode();
/*     */ 
/*     */ 
/*     */     
/* 301 */     arrayOfFunction[336] = TextFunction.CONCATENATE;
/* 302 */     arrayOfFunction[337] = NumericFunction.POWER;
/*     */     
/* 304 */     arrayOfFunction[342] = NumericFunction.RADIANS;
/* 305 */     arrayOfFunction[343] = NumericFunction.DEGREES;
/* 306 */     arrayOfFunction[344] = (Function)new Subtotal();
/* 307 */     arrayOfFunction[345] = (Function)new Sumif();
/* 308 */     arrayOfFunction[346] = (Function)new Countif();
/* 309 */     arrayOfFunction[347] = (Function)new Countblank();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 315 */     arrayOfFunction[354] = (Function)new Roman();
/*     */ 
/*     */     
/* 318 */     arrayOfFunction[359] = (Function)new Hyperlink();
/*     */ 
/*     */     
/* 321 */     arrayOfFunction[362] = MinaMaxa.MAXA;
/* 322 */     arrayOfFunction[363] = MinaMaxa.MINA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 328 */     for (byte b = 0; b < arrayOfFunction.length; b++) {
/* 329 */       Function function = arrayOfFunction[b];
/* 330 */       if (function == null) {
/* 331 */         FunctionMetadata functionMetadata = FunctionMetadataRegistry.getFunctionByIndex(b);
/* 332 */         if (functionMetadata != null)
/*     */         {
/*     */           
/* 335 */           arrayOfFunction[b] = (Function)new NotImplementedFunction(functionMetadata.getName()); } 
/*     */       } 
/*     */     } 
/* 338 */     return arrayOfFunction;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Function getBasicFunction(int paramInt) {
/* 345 */     switch (paramInt) {
/*     */       case 148:
/*     */       case 255:
/* 348 */         return null;
/*     */     } 
/*     */     
/* 351 */     Function function = functions[paramInt];
/* 352 */     if (function == null) {
/* 353 */       throw new NotImplementedException("FuncIx=" + paramInt);
/*     */     }
/* 355 */     return function;
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
/*     */   public static void registerFunction(String paramString, Function paramFunction) {
/* 367 */     FunctionMetadata functionMetadata = FunctionMetadataRegistry.getFunctionByName(paramString);
/* 368 */     if (functionMetadata == null) {
/* 369 */       if (AnalysisToolPak.isATPFunction(paramString)) {
/* 370 */         throw new IllegalArgumentException(paramString + " is a function from the Excel Analysis Toolpack. " + "Use AnalysisToolpack.registerFunction(String name, FreeRefFunction func) instead.");
/*     */       }
/*     */ 
/*     */       
/* 374 */       throw new IllegalArgumentException("Unknown function: " + paramString);
/*     */     } 
/*     */     
/* 377 */     int i = functionMetadata.getIndex();
/* 378 */     if (functions[i] instanceof NotImplementedFunction) {
/* 379 */       functions[i] = paramFunction;
/*     */     } else {
/* 381 */       throw new IllegalArgumentException("POI already implememts " + paramString + ". You cannot override POI's implementations of Excel functions");
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
/*     */   public static Collection<String> getSupportedFunctionNames() {
/* 393 */     TreeSet<String> treeSet = new TreeSet();
/* 394 */     for (byte b = 0; b < functions.length; b++) {
/* 395 */       Function function = functions[b];
/* 396 */       FunctionMetadata functionMetadata = FunctionMetadataRegistry.getFunctionByIndex(b);
/* 397 */       if (function != null && !(function instanceof NotImplementedFunction)) {
/* 398 */         treeSet.add(functionMetadata.getName());
/*     */       }
/*     */     } 
/* 401 */     treeSet.add("INDIRECT");
/* 402 */     return Collections.unmodifiableCollection(treeSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Collection<String> getNotSupportedFunctionNames() {
/* 412 */     TreeSet<String> treeSet = new TreeSet();
/* 413 */     for (byte b = 0; b < functions.length; b++) {
/* 414 */       Function function = functions[b];
/* 415 */       if (function != null && function instanceof NotImplementedFunction) {
/* 416 */         FunctionMetadata functionMetadata = FunctionMetadataRegistry.getFunctionByIndex(b);
/* 417 */         treeSet.add(functionMetadata.getName());
/*     */       } 
/*     */     } 
/* 420 */     treeSet.remove("INDIRECT");
/* 421 */     return Collections.unmodifiableCollection(treeSet);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\FunctionEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */