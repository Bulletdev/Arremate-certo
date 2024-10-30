/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.regex.Pattern;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class Mode
/*     */ {
/*     */   static final String REGULAR = "REGULAR";
/*  25 */   private static final HashMap<String, Mode> MODES = New.hashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean aliasColumnName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean convertInsertNullToZero;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean convertOnlyToSmallerScale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean indexDefinitionInCreateTable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean lowerCaseIdentifiers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean nullConcatIsNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean squareBracketQuotedNames;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean supportOffsetFetch = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean systemColumns;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean uniqueIndexSingleNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean uniqueIndexSingleNullExceptAllColumnsAreNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean treatEmptyStringsAsNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean sysDummy1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean allowPlusForStringConcat;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean logIsLogBase10;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean serialColumnIsNotPK;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean swapConvertFunctionParameters;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isolationLevelInSelectOrInsertStatement;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onDuplicateKeyUpdate;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pattern supportedClientInfoPropertiesRegEx;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean supportPoundSymbolForColumnNames;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean prohibitEmptyInPredicate;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 161 */     Mode mode = new Mode("REGULAR");
/* 162 */     mode.nullConcatIsNull = true;
/* 163 */     add(mode);
/*     */     
/* 165 */     mode = new Mode("DB2");
/* 166 */     mode.aliasColumnName = true;
/* 167 */     mode.supportOffsetFetch = true;
/* 168 */     mode.sysDummy1 = true;
/* 169 */     mode.isolationLevelInSelectOrInsertStatement = true;
/*     */ 
/*     */ 
/*     */     
/* 173 */     mode.supportedClientInfoPropertiesRegEx = Pattern.compile("ApplicationName|ClientAccountingInformation|ClientUser|ClientCorrelationToken");
/*     */ 
/*     */     
/* 176 */     mode.prohibitEmptyInPredicate = true;
/* 177 */     add(mode);
/*     */     
/* 179 */     mode = new Mode("Derby");
/* 180 */     mode.aliasColumnName = true;
/* 181 */     mode.uniqueIndexSingleNull = true;
/* 182 */     mode.supportOffsetFetch = true;
/* 183 */     mode.sysDummy1 = true;
/* 184 */     mode.isolationLevelInSelectOrInsertStatement = true;
/*     */     
/* 186 */     mode.supportedClientInfoPropertiesRegEx = null;
/* 187 */     add(mode);
/*     */     
/* 189 */     mode = new Mode("HSQLDB");
/* 190 */     mode.aliasColumnName = true;
/* 191 */     mode.convertOnlyToSmallerScale = true;
/* 192 */     mode.nullConcatIsNull = true;
/* 193 */     mode.uniqueIndexSingleNull = true;
/* 194 */     mode.allowPlusForStringConcat = true;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     mode.supportedClientInfoPropertiesRegEx = null;
/* 200 */     add(mode);
/*     */     
/* 202 */     mode = new Mode("MSSQLServer");
/* 203 */     mode.aliasColumnName = true;
/* 204 */     mode.squareBracketQuotedNames = true;
/* 205 */     mode.uniqueIndexSingleNull = true;
/* 206 */     mode.allowPlusForStringConcat = true;
/* 207 */     mode.swapConvertFunctionParameters = true;
/* 208 */     mode.supportPoundSymbolForColumnNames = true;
/*     */ 
/*     */     
/* 211 */     mode.supportedClientInfoPropertiesRegEx = null;
/* 212 */     add(mode);
/*     */     
/* 214 */     mode = new Mode("MySQL");
/* 215 */     mode.convertInsertNullToZero = true;
/* 216 */     mode.indexDefinitionInCreateTable = true;
/* 217 */     mode.lowerCaseIdentifiers = true;
/* 218 */     mode.onDuplicateKeyUpdate = true;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 223 */     mode.supportedClientInfoPropertiesRegEx = Pattern.compile(".*");
/*     */     
/* 225 */     mode.prohibitEmptyInPredicate = true;
/* 226 */     add(mode);
/*     */     
/* 228 */     mode = new Mode("Oracle");
/* 229 */     mode.aliasColumnName = true;
/* 230 */     mode.convertOnlyToSmallerScale = true;
/* 231 */     mode.uniqueIndexSingleNullExceptAllColumnsAreNull = true;
/* 232 */     mode.treatEmptyStringsAsNull = true;
/* 233 */     mode.supportPoundSymbolForColumnNames = true;
/*     */ 
/*     */     
/* 236 */     mode.supportedClientInfoPropertiesRegEx = Pattern.compile(".*\\..*");
/*     */     
/* 238 */     mode.prohibitEmptyInPredicate = true;
/* 239 */     add(mode);
/*     */     
/* 241 */     mode = new Mode("PostgreSQL");
/* 242 */     mode.aliasColumnName = true;
/* 243 */     mode.nullConcatIsNull = true;
/* 244 */     mode.supportOffsetFetch = true;
/* 245 */     mode.systemColumns = true;
/* 246 */     mode.logIsLogBase10 = true;
/* 247 */     mode.serialColumnIsNotPK = true;
/*     */ 
/*     */ 
/*     */     
/* 251 */     mode.supportedClientInfoPropertiesRegEx = Pattern.compile("ApplicationName");
/*     */     
/* 253 */     mode.prohibitEmptyInPredicate = true;
/* 254 */     add(mode);
/*     */   }
/*     */   
/*     */   private Mode(String paramString) {
/* 258 */     this.name = paramString;
/*     */   }
/*     */   
/*     */   private static void add(Mode paramMode) {
/* 262 */     MODES.put(StringUtils.toUpperEnglish(paramMode.name), paramMode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Mode getInstance(String paramString) {
/* 272 */     return MODES.get(StringUtils.toUpperEnglish(paramString));
/*     */   }
/*     */   
/*     */   public String getName() {
/* 276 */     return this.name;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\Mode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */