/*     */ package org.apache.poi.ss.formula.atp;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*     */ import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.formula.function.FunctionMetadata;
/*     */ import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
/*     */ import org.apache.poi.ss.formula.functions.Bin2Dec;
/*     */ import org.apache.poi.ss.formula.functions.Complex;
/*     */ import org.apache.poi.ss.formula.functions.Countifs;
/*     */ import org.apache.poi.ss.formula.functions.Dec2Bin;
/*     */ import org.apache.poi.ss.formula.functions.Dec2Hex;
/*     */ import org.apache.poi.ss.formula.functions.Delta;
/*     */ import org.apache.poi.ss.formula.functions.EDate;
/*     */ import org.apache.poi.ss.formula.functions.EOMonth;
/*     */ import org.apache.poi.ss.formula.functions.FactDouble;
/*     */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
/*     */ import org.apache.poi.ss.formula.functions.Hex2Dec;
/*     */ import org.apache.poi.ss.formula.functions.ImReal;
/*     */ import org.apache.poi.ss.formula.functions.Imaginary;
/*     */ import org.apache.poi.ss.formula.functions.Oct2Dec;
/*     */ import org.apache.poi.ss.formula.functions.Quotient;
/*     */ import org.apache.poi.ss.formula.functions.Sumifs;
/*     */ import org.apache.poi.ss.formula.functions.WeekNum;
/*     */ import org.apache.poi.ss.formula.udf.UDFFinder;
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
/*     */ public final class AnalysisToolPak
/*     */   implements UDFFinder
/*     */ {
/*  49 */   public static final UDFFinder instance = new AnalysisToolPak();
/*     */   
/*     */   private static final class NotImplemented implements FreeRefFunction {
/*     */     private final String _functionName;
/*     */     
/*     */     public NotImplemented(String param1String) {
/*  55 */       this._functionName = param1String;
/*     */     }
/*     */     
/*     */     public ValueEval evaluate(ValueEval[] param1ArrayOfValueEval, OperationEvaluationContext param1OperationEvaluationContext) {
/*  59 */       throw new NotImplementedFunctionException(this._functionName);
/*     */     }
/*     */   }
/*     */   
/*  63 */   private final Map<String, FreeRefFunction> _functionsByName = createFunctionsMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FreeRefFunction findFunction(String paramString) {
/*  72 */     if (paramString.startsWith("_xlfn.")) paramString = paramString.substring(6);
/*     */ 
/*     */     
/*  75 */     return this._functionsByName.get(paramString.toUpperCase(Locale.ROOT));
/*     */   }
/*     */   
/*     */   private Map<String, FreeRefFunction> createFunctionsMap() {
/*  79 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(108);
/*     */     
/*  81 */     r((Map)hashMap, "ACCRINT", null);
/*  82 */     r((Map)hashMap, "ACCRINTM", null);
/*  83 */     r((Map)hashMap, "AMORDEGRC", null);
/*  84 */     r((Map)hashMap, "AMORLINC", null);
/*  85 */     r((Map)hashMap, "AVERAGEIF", null);
/*  86 */     r((Map)hashMap, "AVERAGEIFS", null);
/*  87 */     r((Map)hashMap, "BAHTTEXT", null);
/*  88 */     r((Map)hashMap, "BESSELI", null);
/*  89 */     r((Map)hashMap, "BESSELJ", null);
/*  90 */     r((Map)hashMap, "BESSELK", null);
/*  91 */     r((Map)hashMap, "BESSELY", null);
/*  92 */     r((Map)hashMap, "BIN2DEC", Bin2Dec.instance);
/*  93 */     r((Map)hashMap, "BIN2HEX", null);
/*  94 */     r((Map)hashMap, "BIN2OCT", null);
/*  95 */     r((Map)hashMap, "COMPLEX", Complex.instance);
/*  96 */     r((Map)hashMap, "CONVERT", null);
/*  97 */     r((Map)hashMap, "COUNTIFS", null);
/*  98 */     r((Map)hashMap, "COUPDAYBS", null);
/*  99 */     r((Map)hashMap, "COUPDAYS", null);
/* 100 */     r((Map)hashMap, "COUPDAYSNC", null);
/* 101 */     r((Map)hashMap, "COUPNCD", null);
/* 102 */     r((Map)hashMap, "COUPNUM", null);
/* 103 */     r((Map)hashMap, "COUPPCD", null);
/* 104 */     r((Map)hashMap, "CUBEKPIMEMBER", null);
/* 105 */     r((Map)hashMap, "CUBEMEMBER", null);
/* 106 */     r((Map)hashMap, "CUBEMEMBERPROPERTY", null);
/* 107 */     r((Map)hashMap, "CUBERANKEDMEMBER", null);
/* 108 */     r((Map)hashMap, "CUBESET", null);
/* 109 */     r((Map)hashMap, "CUBESETCOUNT", null);
/* 110 */     r((Map)hashMap, "CUBEVALUE", null);
/* 111 */     r((Map)hashMap, "CUMIPMT", null);
/* 112 */     r((Map)hashMap, "CUMPRINC", null);
/* 113 */     r((Map)hashMap, "DEC2BIN", Dec2Bin.instance);
/* 114 */     r((Map)hashMap, "DEC2HEX", Dec2Hex.instance);
/* 115 */     r((Map)hashMap, "DEC2OCT", null);
/* 116 */     r((Map)hashMap, "DELTA", Delta.instance);
/* 117 */     r((Map)hashMap, "DISC", null);
/* 118 */     r((Map)hashMap, "DOLLARDE", null);
/* 119 */     r((Map)hashMap, "DOLLARFR", null);
/* 120 */     r((Map)hashMap, "DURATION", null);
/* 121 */     r((Map)hashMap, "EDATE", EDate.instance);
/* 122 */     r((Map)hashMap, "EFFECT", null);
/* 123 */     r((Map)hashMap, "EOMONTH", EOMonth.instance);
/* 124 */     r((Map)hashMap, "ERF", null);
/* 125 */     r((Map)hashMap, "ERFC", null);
/* 126 */     r((Map)hashMap, "FACTDOUBLE", FactDouble.instance);
/* 127 */     r((Map)hashMap, "FVSCHEDULE", null);
/* 128 */     r((Map)hashMap, "GCD", null);
/* 129 */     r((Map)hashMap, "GESTEP", null);
/* 130 */     r((Map)hashMap, "HEX2BIN", null);
/* 131 */     r((Map)hashMap, "HEX2DEC", Hex2Dec.instance);
/* 132 */     r((Map)hashMap, "HEX2OCT", null);
/* 133 */     r((Map)hashMap, "IFERROR", IfError.instance);
/* 134 */     r((Map)hashMap, "IMABS", null);
/* 135 */     r((Map)hashMap, "IMAGINARY", Imaginary.instance);
/* 136 */     r((Map)hashMap, "IMARGUMENT", null);
/* 137 */     r((Map)hashMap, "IMCONJUGATE", null);
/* 138 */     r((Map)hashMap, "IMCOS", null);
/* 139 */     r((Map)hashMap, "IMDIV", null);
/* 140 */     r((Map)hashMap, "IMEXP", null);
/* 141 */     r((Map)hashMap, "IMLN", null);
/* 142 */     r((Map)hashMap, "IMLOG10", null);
/* 143 */     r((Map)hashMap, "IMLOG2", null);
/* 144 */     r((Map)hashMap, "IMPOWER", null);
/* 145 */     r((Map)hashMap, "IMPRODUCT", null);
/* 146 */     r((Map)hashMap, "IMREAL", ImReal.instance);
/* 147 */     r((Map)hashMap, "IMSIN", null);
/* 148 */     r((Map)hashMap, "IMSQRT", null);
/* 149 */     r((Map)hashMap, "IMSUB", null);
/* 150 */     r((Map)hashMap, "IMSUM", null);
/* 151 */     r((Map)hashMap, "INTRATE", null);
/* 152 */     r((Map)hashMap, "ISEVEN", ParityFunction.IS_EVEN);
/* 153 */     r((Map)hashMap, "ISODD", ParityFunction.IS_ODD);
/* 154 */     r((Map)hashMap, "JIS", null);
/* 155 */     r((Map)hashMap, "LCM", null);
/* 156 */     r((Map)hashMap, "MDURATION", null);
/* 157 */     r((Map)hashMap, "MROUND", MRound.instance);
/* 158 */     r((Map)hashMap, "MULTINOMIAL", null);
/* 159 */     r((Map)hashMap, "NETWORKDAYS", NetworkdaysFunction.instance);
/* 160 */     r((Map)hashMap, "NOMINAL", null);
/* 161 */     r((Map)hashMap, "OCT2BIN", null);
/* 162 */     r((Map)hashMap, "OCT2DEC", Oct2Dec.instance);
/* 163 */     r((Map)hashMap, "OCT2HEX", null);
/* 164 */     r((Map)hashMap, "ODDFPRICE", null);
/* 165 */     r((Map)hashMap, "ODDFYIELD", null);
/* 166 */     r((Map)hashMap, "ODDLPRICE", null);
/* 167 */     r((Map)hashMap, "ODDLYIELD", null);
/* 168 */     r((Map)hashMap, "PRICE", null);
/* 169 */     r((Map)hashMap, "PRICEDISC", null);
/* 170 */     r((Map)hashMap, "PRICEMAT", null);
/* 171 */     r((Map)hashMap, "QUOTIENT", Quotient.instance);
/* 172 */     r((Map)hashMap, "RANDBETWEEN", RandBetween.instance);
/* 173 */     r((Map)hashMap, "RECEIVED", null);
/* 174 */     r((Map)hashMap, "RTD", null);
/* 175 */     r((Map)hashMap, "SERIESSUM", null);
/* 176 */     r((Map)hashMap, "SQRTPI", null);
/* 177 */     r((Map)hashMap, "SUMIFS", Sumifs.instance);
/* 178 */     r((Map)hashMap, "TBILLEQ", null);
/* 179 */     r((Map)hashMap, "TBILLPRICE", null);
/* 180 */     r((Map)hashMap, "TBILLYIELD", null);
/* 181 */     r((Map)hashMap, "WEEKNUM", WeekNum.instance);
/* 182 */     r((Map)hashMap, "WORKDAY", WorkdayFunction.instance);
/* 183 */     r((Map)hashMap, "XIRR", null);
/* 184 */     r((Map)hashMap, "XNPV", null);
/* 185 */     r((Map)hashMap, "YEARFRAC", YearFrac.instance);
/* 186 */     r((Map)hashMap, "YIELD", null);
/* 187 */     r((Map)hashMap, "YIELDDISC", null);
/* 188 */     r((Map)hashMap, "YIELDMAT", null);
/* 189 */     r((Map)hashMap, "COUNTIFS", Countifs.instance);
/*     */     
/* 191 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private static void r(Map<String, FreeRefFunction> paramMap, String paramString, FreeRefFunction paramFreeRefFunction) {
/* 195 */     FreeRefFunction freeRefFunction = (paramFreeRefFunction == null) ? new NotImplemented(paramString) : paramFreeRefFunction;
/* 196 */     paramMap.put(paramString, freeRefFunction);
/*     */   }
/*     */   
/*     */   public static boolean isATPFunction(String paramString) {
/* 200 */     AnalysisToolPak analysisToolPak = (AnalysisToolPak)instance;
/*     */     
/* 202 */     return analysisToolPak._functionsByName.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Collection<String> getSupportedFunctionNames() {
/* 212 */     AnalysisToolPak analysisToolPak = (AnalysisToolPak)instance;
/* 213 */     TreeSet<? extends String> treeSet = new TreeSet();
/* 214 */     for (Map.Entry<String, FreeRefFunction> entry : analysisToolPak._functionsByName.entrySet()) {
/* 215 */       FreeRefFunction freeRefFunction = (FreeRefFunction)entry.getValue();
/* 216 */       if (freeRefFunction != null && !(freeRefFunction instanceof NotImplemented)) {
/* 217 */         treeSet.add(entry.getKey());
/*     */       }
/*     */     } 
/* 220 */     return Collections.unmodifiableCollection(treeSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Collection<String> getNotSupportedFunctionNames() {
/* 230 */     AnalysisToolPak analysisToolPak = (AnalysisToolPak)instance;
/* 231 */     TreeSet<? extends String> treeSet = new TreeSet();
/* 232 */     for (Map.Entry<String, FreeRefFunction> entry : analysisToolPak._functionsByName.entrySet()) {
/* 233 */       FreeRefFunction freeRefFunction = (FreeRefFunction)entry.getValue();
/* 234 */       if (freeRefFunction instanceof NotImplemented) {
/* 235 */         treeSet.add(entry.getKey());
/*     */       }
/*     */     } 
/* 238 */     return Collections.unmodifiableCollection(treeSet);
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
/*     */   public static void registerFunction(String paramString, FreeRefFunction paramFreeRefFunction) {
/* 250 */     AnalysisToolPak analysisToolPak = (AnalysisToolPak)instance;
/* 251 */     if (!isATPFunction(paramString)) {
/* 252 */       FunctionMetadata functionMetadata = FunctionMetadataRegistry.getFunctionByName(paramString);
/* 253 */       if (functionMetadata != null) {
/* 254 */         throw new IllegalArgumentException(paramString + " is a built-in Excel function. " + "Use FunctoinEval.registerFunction(String name, Function func) instead.");
/*     */       }
/*     */ 
/*     */       
/* 258 */       throw new IllegalArgumentException(paramString + " is not a function from the Excel Analysis Toolpack.");
/*     */     } 
/* 260 */     FreeRefFunction freeRefFunction = analysisToolPak.findFunction(paramString);
/* 261 */     if (freeRefFunction != null && !(freeRefFunction instanceof NotImplemented)) {
/* 262 */       throw new IllegalArgumentException("POI already implememts " + paramString + ". You cannot override POI's implementations of Excel functions");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 267 */     analysisToolPak._functionsByName.put(paramString, paramFreeRefFunction);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\AnalysisToolPak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */