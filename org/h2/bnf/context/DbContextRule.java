/*     */ package org.h2.bnf.context;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import org.h2.bnf.Bnf;
/*     */ import org.h2.bnf.BnfVisitor;
/*     */ import org.h2.bnf.Rule;
/*     */ import org.h2.bnf.RuleElement;
/*     */ import org.h2.bnf.RuleHead;
/*     */ import org.h2.bnf.RuleList;
/*     */ import org.h2.bnf.Sentence;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.message.DbException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DbContextRule
/*     */   implements Rule
/*     */ {
/*     */   public static final int COLUMN = 0;
/*     */   public static final int TABLE = 1;
/*     */   public static final int TABLE_ALIAS = 2;
/*     */   public static final int NEW_TABLE_ALIAS = 3;
/*     */   public static final int COLUMN_ALIAS = 4;
/*     */   public static final int SCHEMA = 5;
/*     */   public static final int PROCEDURE = 6;
/*     */   private final DbContents contents;
/*     */   private final int type;
/*     */   private String columnType;
/*     */   
/*     */   public DbContextRule(DbContents paramDbContents, int paramInt) {
/*  49 */     this.contents = paramDbContents;
/*  50 */     this.type = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLinks(HashMap<String, RuleHead> paramHashMap) {}
/*     */   
/*     */   public void setColumnType(String paramString) {
/*  57 */     this.columnType = paramString;
/*     */   }
/*     */   
/*     */   public void accept(BnfVisitor paramBnfVisitor) {}
/*     */   
/*     */   public boolean autoComplete(Sentence paramSentence) {
/*     */     DbSchema arrayOfDbSchema[], dbSchema1;
/*     */     byte b;
/*     */     HashSet hashSet;
/*     */     String str5;
/*     */     DbTableOrView[] arrayOfDbTableOrView;
/*     */     String str4;
/*     */     DbSchema dbSchema2;
/*     */     String str6;
/*     */     DbTableOrView dbTableOrView1, dbTableOrView2;
/*  72 */     String str1 = paramSentence.getQuery(), str2 = str1;
/*  73 */     String str3 = paramSentence.getQueryUpper();
/*  74 */     switch (this.type) {
/*     */       case 5:
/*  76 */         arrayOfDbSchema = this.contents.getSchemas();
/*  77 */         str5 = null;
/*  78 */         dbSchema2 = null;
/*  79 */         for (DbSchema dbSchema : arrayOfDbSchema) {
/*  80 */           String str = StringUtils.toUpperEnglish(dbSchema.name);
/*  81 */           if (str3.startsWith(str)) {
/*  82 */             if (str5 == null || str.length() > str5.length()) {
/*  83 */               str5 = str;
/*  84 */               dbSchema2 = dbSchema;
/*     */             } 
/*  86 */           } else if ((str2.length() == 0 || str.startsWith(str3)) && 
/*  87 */             str2.length() < str.length()) {
/*  88 */             paramSentence.add(str, str.substring(str2.length()), this.type);
/*  89 */             paramSentence.add(dbSchema.quotedName + ".", dbSchema.quotedName.substring(str2.length()) + ".", 0);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*  95 */         if (str5 != null) {
/*  96 */           paramSentence.setLastMatchedSchema(dbSchema2);
/*  97 */           str2 = str2.substring(str5.length());
/*     */         } 
/*     */         break;
/*     */       
/*     */       case 1:
/* 102 */         dbSchema1 = paramSentence.getLastMatchedSchema();
/* 103 */         if (dbSchema1 == null) {
/* 104 */           dbSchema1 = this.contents.getDefaultSchema();
/*     */         }
/* 106 */         arrayOfDbTableOrView = dbSchema1.getTables();
/* 107 */         dbSchema2 = null;
/* 108 */         dbTableOrView2 = null;
/* 109 */         for (DbTableOrView dbTableOrView : arrayOfDbTableOrView) {
/* 110 */           String str7 = str3;
/* 111 */           String str8 = StringUtils.toUpperEnglish(dbTableOrView.getName());
/* 112 */           if (dbTableOrView.getQuotedName().length() > str8.length()) {
/* 113 */             str8 = dbTableOrView.getQuotedName();
/* 114 */             str7 = str1;
/*     */           } 
/* 116 */           if (str7.startsWith(str8)) {
/* 117 */             if (dbSchema2 == null || str8.length() > dbSchema2.length()) {
/* 118 */               str6 = str8;
/* 119 */               dbTableOrView2 = dbTableOrView;
/*     */             } 
/* 121 */           } else if ((str2.length() == 0 || str8.startsWith(str7)) && 
/* 122 */             str2.length() < str8.length()) {
/* 123 */             paramSentence.add(dbTableOrView.getQuotedName(), dbTableOrView.getQuotedName().substring(str2.length()), 0);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 129 */         if (str6 != null) {
/* 130 */           paramSentence.setLastMatchedTable(dbTableOrView2);
/* 131 */           paramSentence.addTable(dbTableOrView2);
/* 132 */           str2 = str2.substring(str6.length());
/*     */         } 
/*     */         break;
/*     */       
/*     */       case 3:
/* 137 */         str2 = autoCompleteTableAlias(paramSentence, true);
/*     */         break;
/*     */       case 2:
/* 140 */         str2 = autoCompleteTableAlias(paramSentence, false);
/*     */         break;
/*     */       case 4:
/* 143 */         b = 0;
/* 144 */         if (str1.indexOf(' ') < 0) {
/*     */           break;
/*     */         }
/* 147 */         for (; b < str3.length(); b++) {
/* 148 */           char c = str3.charAt(b);
/* 149 */           if (c != '_' && !Character.isLetterOrDigit(c)) {
/*     */             break;
/*     */           }
/*     */         } 
/* 153 */         if (b == 0) {
/*     */           break;
/*     */         }
/* 156 */         str4 = str3.substring(0, b);
/* 157 */         if (Parser.isKeyword(str4, true)) {
/*     */           break;
/*     */         }
/* 160 */         str2 = str2.substring(str4.length());
/*     */         break;
/*     */       
/*     */       case 0:
/* 164 */         hashSet = paramSentence.getTables();
/* 165 */         str4 = null;
/* 166 */         dbTableOrView1 = paramSentence.getLastMatchedTable();
/* 167 */         if (dbTableOrView1 != null && dbTableOrView1.getColumns() != null) {
/* 168 */           for (DbColumn dbColumn : dbTableOrView1.getColumns()) {
/* 169 */             String str7 = str3;
/* 170 */             String str8 = StringUtils.toUpperEnglish(dbColumn.getName());
/* 171 */             if (dbColumn.getQuotedName().length() > str8.length()) {
/* 172 */               str8 = dbColumn.getQuotedName();
/* 173 */               str7 = str1;
/*     */             } 
/* 175 */             if (str7.startsWith(str8) && (this.columnType == null || dbColumn.getDataType().contains(this.columnType))) {
/*     */ 
/*     */               
/* 178 */               String str = str2.substring(str8.length());
/* 179 */               if (str4 == null || str.length() < str4.length()) {
/* 180 */                 str4 = str;
/* 181 */               } else if ((str2.length() == 0 || str8.startsWith(str7)) && 
/* 182 */                 str2.length() < str8.length()) {
/* 183 */                 paramSentence.add(dbColumn.getName(), dbColumn.getName().substring(str2.length()), 0);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 191 */         for (DbSchema dbSchema : this.contents.getSchemas()) {
/* 192 */           for (DbTableOrView dbTableOrView : dbSchema.getTables()) {
/* 193 */             if (dbTableOrView == dbTableOrView1 || hashSet == null || hashSet.contains(dbTableOrView))
/*     */             {
/*     */               
/* 196 */               if (dbTableOrView != null && dbTableOrView.getColumns() != null)
/*     */               {
/*     */                 
/* 199 */                 for (DbColumn dbColumn : dbTableOrView.getColumns()) {
/* 200 */                   String str = StringUtils.toUpperEnglish(dbColumn.getName());
/*     */                   
/* 202 */                   if (this.columnType == null || dbColumn.getDataType().contains(this.columnType))
/*     */                   {
/* 204 */                     if (str3.startsWith(str)) {
/* 205 */                       String str7 = str2.substring(str.length());
/* 206 */                       if (str4 == null || str7.length() < str4.length()) {
/* 207 */                         str4 = str7;
/*     */                       }
/* 209 */                     } else if ((str2.length() == 0 || str.startsWith(str3)) && 
/* 210 */                       str2.length() < str.length()) {
/* 211 */                       paramSentence.add(dbColumn.getName(), dbColumn.getName().substring(str2.length()), 0);
/*     */                     } 
/*     */                   }
/*     */                 } 
/*     */               }
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 220 */         if (str4 != null) {
/* 221 */           str2 = str4;
/*     */         }
/*     */         break;
/*     */       
/*     */       case 6:
/* 226 */         autoCompleteProcedure(paramSentence);
/*     */         break;
/*     */       default:
/* 229 */         throw DbException.throwInternalError("type=" + this.type);
/*     */     } 
/* 231 */     if (!str2.equals(str1)) {
/* 232 */       while (Bnf.startWithSpace(str2)) {
/* 233 */         str2 = str2.substring(1);
/*     */       }
/* 235 */       paramSentence.setQuery(str2);
/* 236 */       return true;
/*     */     } 
/* 238 */     return false;
/*     */   }
/*     */   private void autoCompleteProcedure(Sentence paramSentence) {
/* 241 */     DbSchema dbSchema = paramSentence.getLastMatchedSchema();
/* 242 */     if (dbSchema == null) {
/* 243 */       dbSchema = this.contents.getDefaultSchema();
/*     */     }
/* 245 */     String str1 = paramSentence.getQueryUpper();
/* 246 */     String str2 = str1;
/* 247 */     if (str1.contains("(")) {
/* 248 */       str2 = str1.substring(0, str1.indexOf('(')).trim();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 253 */     RuleElement ruleElement1 = new RuleElement("(", "Function");
/* 254 */     RuleElement ruleElement2 = new RuleElement(")", "Function");
/* 255 */     RuleElement ruleElement3 = new RuleElement(",", "Function");
/*     */ 
/*     */     
/* 258 */     for (DbProcedure dbProcedure : dbSchema.getProcedures()) {
/* 259 */       String str = dbProcedure.getName();
/* 260 */       if (str.startsWith(str2)) {
/*     */         
/* 262 */         RuleElement ruleElement = new RuleElement(str, "Function");
/*     */         
/* 264 */         RuleList ruleList = new RuleList((Rule)ruleElement, (Rule)ruleElement1, false);
/*     */         
/* 266 */         if (str1.contains("(")) {
/* 267 */           for (DbColumn dbColumn : dbProcedure.getParameters()) {
/* 268 */             if (dbColumn.getPosition() > 1) {
/* 269 */               ruleList = new RuleList((Rule)ruleList, (Rule)ruleElement3, false);
/*     */             }
/* 271 */             DbContextRule dbContextRule = new DbContextRule(this.contents, 0);
/*     */             
/* 273 */             String str3 = dbColumn.getDataType();
/*     */             
/* 275 */             if (str3.contains("(")) {
/* 276 */               str3 = str3.substring(0, str3.indexOf('('));
/*     */             }
/*     */             
/* 279 */             dbContextRule.setColumnType(str3);
/* 280 */             ruleList = new RuleList((Rule)ruleList, dbContextRule, false);
/*     */           } 
/* 282 */           ruleList = new RuleList((Rule)ruleList, (Rule)ruleElement2, false);
/*     */         } 
/* 284 */         ruleList.autoComplete(paramSentence);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static String autoCompleteTableAlias(Sentence paramSentence, boolean paramBoolean) {
/* 291 */     String str1 = paramSentence.getQuery();
/* 292 */     String str2 = paramSentence.getQueryUpper();
/* 293 */     byte b = 0;
/* 294 */     for (; b < str2.length(); b++) {
/* 295 */       char c = str2.charAt(b);
/* 296 */       if (c != '_' && !Character.isLetterOrDigit(c)) {
/*     */         break;
/*     */       }
/*     */     } 
/* 300 */     if (b == 0) {
/* 301 */       return str1;
/*     */     }
/* 303 */     String str3 = str2.substring(0, b);
/* 304 */     if ("SET".equals(str3) || Parser.isKeyword(str3, true)) {
/* 305 */       return str1;
/*     */     }
/* 307 */     if (paramBoolean) {
/* 308 */       paramSentence.addAlias(str3, paramSentence.getLastTable());
/*     */     }
/* 310 */     HashMap hashMap = paramSentence.getAliases();
/* 311 */     if ((hashMap != null && hashMap.containsKey(str3)) || paramSentence.getLastTable() == null) {
/*     */       
/* 313 */       if (paramBoolean && str1.length() == str3.length()) {
/* 314 */         return str1;
/*     */       }
/* 316 */       str1 = str1.substring(str3.length());
/* 317 */       if (str1.length() == 0) {
/* 318 */         paramSentence.add(str3 + ".", ".", 0);
/*     */       }
/* 320 */       return str1;
/*     */     } 
/* 322 */     HashSet hashSet = paramSentence.getTables();
/* 323 */     if (hashSet != null) {
/* 324 */       String str = null;
/* 325 */       for (DbTableOrView dbTableOrView : hashSet) {
/* 326 */         String str4 = StringUtils.toUpperEnglish(dbTableOrView.getName());
/*     */         
/* 328 */         if (str3.startsWith(str4) && (str == null || str4.length() > str.length())) {
/*     */           
/* 330 */           paramSentence.setLastMatchedTable(dbTableOrView);
/* 331 */           str = str4; continue;
/* 332 */         }  if (str1.length() == 0 || str4.startsWith(str3)) {
/* 333 */           paramSentence.add(str4 + ".", str4.substring(str1.length()) + ".", 0);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 338 */       if (str != null) {
/* 339 */         str1 = str1.substring(str.length());
/* 340 */         if (str1.length() == 0) {
/* 341 */           paramSentence.add(str3 + ".", ".", 0);
/*     */         }
/* 343 */         return str1;
/*     */       } 
/*     */     } 
/* 346 */     return str1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\context\DbContextRule.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */