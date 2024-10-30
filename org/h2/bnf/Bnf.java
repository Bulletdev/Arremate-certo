/*     */ package org.h2.bnf;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.StringTokenizer;
/*     */ import org.h2.bnf.context.DbContextRule;
/*     */ import org.h2.tools.Csv;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
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
/*     */ public class Bnf
/*     */ {
/*  34 */   private final HashMap<String, RuleHead> ruleMap = New.hashMap();
/*     */   
/*     */   private String syntax;
/*     */   
/*     */   private String currentToken;
/*     */   
/*     */   private String[] tokens;
/*     */   
/*     */   private char firstChar;
/*     */   
/*     */   private int index;
/*     */   
/*     */   private Rule lastRepeat;
/*     */   private ArrayList<RuleHead> statements;
/*     */   private String currentTopic;
/*     */   
/*     */   public static Bnf getInstance(Reader paramReader) throws SQLException, IOException {
/*  51 */     Bnf bnf = new Bnf();
/*  52 */     if (paramReader == null) {
/*  53 */       byte[] arrayOfByte = Utils.getResource("/org/h2/res/help.csv");
/*  54 */       paramReader = new InputStreamReader(new ByteArrayInputStream(arrayOfByte));
/*     */     } 
/*  56 */     bnf.parse(paramReader);
/*  57 */     return bnf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAlias(String paramString1, String paramString2) {
/*  67 */     RuleHead ruleHead = this.ruleMap.get(paramString2);
/*  68 */     this.ruleMap.put(paramString1, ruleHead);
/*     */   }
/*     */   
/*     */   private void addFixedRule(String paramString, int paramInt) {
/*  72 */     RuleFixed ruleFixed = new RuleFixed(paramInt);
/*  73 */     addRule(paramString, "Fixed", ruleFixed);
/*     */   }
/*     */   
/*     */   private RuleHead addRule(String paramString1, String paramString2, Rule paramRule) {
/*  77 */     RuleHead ruleHead = new RuleHead(paramString2, paramString1, paramRule);
/*  78 */     String str = StringUtils.toLowerEnglish(paramString1.trim().replace(' ', '_'));
/*  79 */     if (this.ruleMap.get(str) != null) {
/*  80 */       throw new AssertionError("already exists: " + paramString1);
/*     */     }
/*  82 */     this.ruleMap.put(str, ruleHead);
/*  83 */     return ruleHead;
/*     */   }
/*     */   
/*     */   private void parse(Reader paramReader) throws SQLException, IOException {
/*  87 */     Rule rule = null;
/*  88 */     this.statements = New.arrayList();
/*  89 */     Csv csv = new Csv();
/*  90 */     csv.setLineCommentCharacter('#');
/*  91 */     ResultSet resultSet = csv.read(paramReader, null);
/*  92 */     while (resultSet.next()) {
/*  93 */       String str1 = resultSet.getString("SECTION").trim();
/*  94 */       if (str1.startsWith("System")) {
/*     */         continue;
/*     */       }
/*  97 */       String str2 = resultSet.getString("TOPIC");
/*  98 */       this.syntax = resultSet.getString("SYNTAX").trim();
/*  99 */       this.currentTopic = str1;
/* 100 */       this.tokens = tokenize();
/* 101 */       this.index = 0;
/* 102 */       Rule rule1 = parseRule();
/* 103 */       if (str1.startsWith("Command")) {
/* 104 */         rule1 = new RuleList(rule1, new RuleElement(";\n\n", this.currentTopic), false);
/*     */       }
/* 106 */       RuleHead ruleHead = addRule(str2, str1, rule1);
/* 107 */       if (str1.startsWith("Function")) {
/* 108 */         if (rule == null) {
/* 109 */           rule = rule1; continue;
/*     */         } 
/* 111 */         rule = new RuleList(rule1, rule, true); continue;
/*     */       } 
/* 113 */       if (str1.startsWith("Commands")) {
/* 114 */         this.statements.add(ruleHead);
/*     */       }
/*     */     } 
/* 117 */     addRule("@func@", "Function", rule);
/* 118 */     addFixedRule("@ymd@", 0);
/* 119 */     addFixedRule("@hms@", 1);
/* 120 */     addFixedRule("@nanos@", 2);
/* 121 */     addFixedRule("anything_except_single_quote", 3);
/* 122 */     addFixedRule("anything_except_double_quote", 4);
/* 123 */     addFixedRule("anything_until_end_of_line", 5);
/* 124 */     addFixedRule("anything_until_end_comment", 6);
/* 125 */     addFixedRule("anything_except_two_dollar_signs", 8);
/* 126 */     addFixedRule("anything", 7);
/* 127 */     addFixedRule("@hex_start@", 10);
/* 128 */     addFixedRule("@concat@", 11);
/* 129 */     addFixedRule("@az_@", 12);
/* 130 */     addFixedRule("@af@", 13);
/* 131 */     addFixedRule("@digit@", 14);
/* 132 */     addFixedRule("@open_bracket@", 15);
/* 133 */     addFixedRule("@close_bracket@", 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visit(BnfVisitor paramBnfVisitor, String paramString) {
/* 143 */     this.syntax = paramString;
/* 144 */     this.tokens = tokenize();
/* 145 */     this.index = 0;
/* 146 */     Rule rule = parseRule();
/* 147 */     rule.setLinks(this.ruleMap);
/* 148 */     rule.accept(paramBnfVisitor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean startWithSpace(String paramString) {
/* 158 */     return (paramString.length() > 0 && Character.isWhitespace(paramString.charAt(0)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getRuleMapKey(String paramString) {
/* 168 */     StringBuilder stringBuilder = new StringBuilder();
/* 169 */     for (char c : paramString.toCharArray()) {
/* 170 */       if (Character.isUpperCase(c)) {
/* 171 */         stringBuilder.append('_').append(Character.toLowerCase(c));
/*     */       } else {
/* 173 */         stringBuilder.append(c);
/*     */       } 
/*     */     } 
/* 176 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RuleHead getRuleHead(String paramString) {
/* 186 */     return this.ruleMap.get(paramString);
/*     */   }
/*     */   
/*     */   private Rule parseRule() {
/* 190 */     read();
/* 191 */     return parseOr();
/*     */   }
/*     */   
/*     */   private Rule parseOr() {
/* 195 */     Rule rule = parseList();
/* 196 */     if (this.firstChar == '|') {
/* 197 */       read();
/* 198 */       rule = new RuleList(rule, parseOr(), true);
/*     */     } 
/* 200 */     this.lastRepeat = rule;
/* 201 */     return rule;
/*     */   }
/*     */   
/*     */   private Rule parseList() {
/* 205 */     Rule rule = parseToken();
/* 206 */     if (this.firstChar != '|' && this.firstChar != ']' && this.firstChar != '}' && this.firstChar != '\000')
/*     */     {
/* 208 */       rule = new RuleList(rule, parseList(), false);
/*     */     }
/* 210 */     this.lastRepeat = rule;
/* 211 */     return rule;
/*     */   }
/*     */   
/*     */   private Rule parseToken() {
/*     */     Rule rule;
/* 216 */     if ((this.firstChar >= 'A' && this.firstChar <= 'Z') || (this.firstChar >= 'a' && this.firstChar <= 'z')) {
/*     */ 
/*     */       
/* 219 */       rule = new RuleElement(this.currentToken, this.currentTopic);
/* 220 */     } else if (this.firstChar == '[') {
/* 221 */       read();
/* 222 */       Rule rule1 = parseOr();
/* 223 */       RuleOptional ruleOptional = new RuleOptional(rule1);
/* 224 */       if (this.firstChar != ']') {
/* 225 */         throw new AssertionError("expected ], got " + this.currentToken + " syntax:" + this.syntax);
/*     */       }
/*     */     }
/* 228 */     else if (this.firstChar == '{') {
/* 229 */       read();
/* 230 */       rule = parseOr();
/* 231 */       if (this.firstChar != '}') {
/* 232 */         throw new AssertionError("expected }, got " + this.currentToken + " syntax:" + this.syntax);
/*     */       }
/*     */     }
/* 235 */     else if ("@commaDots@".equals(this.currentToken)) {
/* 236 */       RuleList ruleList = new RuleList(new RuleElement(",", this.currentTopic), this.lastRepeat, false);
/* 237 */       rule = new RuleRepeat(ruleList, true);
/* 238 */     } else if ("@dots@".equals(this.currentToken)) {
/* 239 */       rule = new RuleRepeat(this.lastRepeat, false);
/*     */     } else {
/* 241 */       rule = new RuleElement(this.currentToken, this.currentTopic);
/*     */     } 
/* 243 */     this.lastRepeat = rule;
/* 244 */     read();
/* 245 */     return rule;
/*     */   }
/*     */   
/*     */   private void read() {
/* 249 */     if (this.index < this.tokens.length) {
/* 250 */       this.currentToken = this.tokens[this.index++];
/* 251 */       this.firstChar = this.currentToken.charAt(0);
/*     */     } else {
/* 253 */       this.currentToken = "";
/* 254 */       this.firstChar = Character.MIN_VALUE;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String[] tokenize() {
/* 259 */     ArrayList<String> arrayList = New.arrayList();
/* 260 */     this.syntax = StringUtils.replaceAll(this.syntax, "yyyy-MM-dd", "@ymd@");
/* 261 */     this.syntax = StringUtils.replaceAll(this.syntax, "hh:mm:ss", "@hms@");
/* 262 */     this.syntax = StringUtils.replaceAll(this.syntax, "nnnnnnnnn", "@nanos@");
/* 263 */     this.syntax = StringUtils.replaceAll(this.syntax, "function", "@func@");
/* 264 */     this.syntax = StringUtils.replaceAll(this.syntax, "0x", "@hexStart@");
/* 265 */     this.syntax = StringUtils.replaceAll(this.syntax, ",...", "@commaDots@");
/* 266 */     this.syntax = StringUtils.replaceAll(this.syntax, "...", "@dots@");
/* 267 */     this.syntax = StringUtils.replaceAll(this.syntax, "||", "@concat@");
/* 268 */     this.syntax = StringUtils.replaceAll(this.syntax, "a-z|_", "@az_@");
/* 269 */     this.syntax = StringUtils.replaceAll(this.syntax, "A-Z|_", "@az_@");
/* 270 */     this.syntax = StringUtils.replaceAll(this.syntax, "A-F", "@af@");
/* 271 */     this.syntax = StringUtils.replaceAll(this.syntax, "0-9", "@digit@");
/* 272 */     this.syntax = StringUtils.replaceAll(this.syntax, "'['", "@openBracket@");
/* 273 */     this.syntax = StringUtils.replaceAll(this.syntax, "']'", "@closeBracket@");
/* 274 */     StringTokenizer stringTokenizer = getTokenizer(this.syntax);
/* 275 */     while (stringTokenizer.hasMoreTokens()) {
/* 276 */       String str = stringTokenizer.nextToken();
/*     */       
/* 278 */       str = StringUtils.cache(str);
/* 279 */       if (str.length() == 1 && 
/* 280 */         " \r\n".indexOf(str.charAt(0)) >= 0) {
/*     */         continue;
/*     */       }
/*     */       
/* 284 */       arrayList.add(str);
/*     */     } 
/* 286 */     return arrayList.<String>toArray(new String[arrayList.size()]);
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
/*     */   public HashMap<String, String> getNextTokenList(String paramString) {
/* 302 */     Sentence sentence = new Sentence();
/* 303 */     sentence.setQuery(paramString);
/*     */     try {
/* 305 */       for (RuleHead ruleHead : this.statements) {
/* 306 */         if (!ruleHead.getSection().startsWith("Commands")) {
/*     */           continue;
/*     */         }
/* 309 */         sentence.start();
/* 310 */         if (ruleHead.getRule().autoComplete(sentence)) {
/*     */           break;
/*     */         }
/*     */       } 
/* 314 */     } catch (IllegalStateException illegalStateException) {}
/*     */ 
/*     */     
/* 317 */     return sentence.getNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void linkStatements() {
/* 325 */     for (RuleHead ruleHead : this.ruleMap.values()) {
/* 326 */       ruleHead.getRule().setLinks(this.ruleMap);
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
/*     */   public void updateTopic(String paramString, DbContextRule paramDbContextRule) {
/* 338 */     paramString = StringUtils.toLowerEnglish(paramString);
/* 339 */     RuleHead ruleHead = this.ruleMap.get(paramString);
/* 340 */     if (ruleHead == null) {
/* 341 */       ruleHead = new RuleHead("db", paramString, (Rule)paramDbContextRule);
/* 342 */       this.ruleMap.put(paramString, ruleHead);
/* 343 */       this.statements.add(ruleHead);
/*     */     } else {
/* 345 */       ruleHead.setRule((Rule)paramDbContextRule);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<RuleHead> getStatements() {
/* 355 */     return this.statements;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StringTokenizer getTokenizer(String paramString) {
/* 365 */     return new StringTokenizer(paramString, " [](){}|.,\r\n<>:-+*/=<\">!'$", true);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\Bnf.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */