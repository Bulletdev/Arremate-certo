/*      */ package org.apache.poi.ss.formula;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Locale;
/*      */ import java.util.regex.Pattern;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.formula.constant.ErrorConstant;
/*      */ import org.apache.poi.ss.formula.function.FunctionMetadata;
/*      */ import org.apache.poi.ss.formula.function.FunctionMetadataRegistry;
/*      */ import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
/*      */ import org.apache.poi.ss.formula.ptg.AddPtg;
/*      */ import org.apache.poi.ss.formula.ptg.Area3DPxg;
/*      */ import org.apache.poi.ss.formula.ptg.AreaPtg;
/*      */ import org.apache.poi.ss.formula.ptg.ArrayPtg;
/*      */ import org.apache.poi.ss.formula.ptg.AttrPtg;
/*      */ import org.apache.poi.ss.formula.ptg.BoolPtg;
/*      */ import org.apache.poi.ss.formula.ptg.ConcatPtg;
/*      */ import org.apache.poi.ss.formula.ptg.DividePtg;
/*      */ import org.apache.poi.ss.formula.ptg.EqualPtg;
/*      */ import org.apache.poi.ss.formula.ptg.ErrPtg;
/*      */ import org.apache.poi.ss.formula.ptg.FuncPtg;
/*      */ import org.apache.poi.ss.formula.ptg.FuncVarPtg;
/*      */ import org.apache.poi.ss.formula.ptg.GreaterEqualPtg;
/*      */ import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
/*      */ import org.apache.poi.ss.formula.ptg.IntPtg;
/*      */ import org.apache.poi.ss.formula.ptg.IntersectionPtg;
/*      */ import org.apache.poi.ss.formula.ptg.LessEqualPtg;
/*      */ import org.apache.poi.ss.formula.ptg.LessThanPtg;
/*      */ import org.apache.poi.ss.formula.ptg.MemAreaPtg;
/*      */ import org.apache.poi.ss.formula.ptg.MemFuncPtg;
/*      */ import org.apache.poi.ss.formula.ptg.MissingArgPtg;
/*      */ import org.apache.poi.ss.formula.ptg.MultiplyPtg;
/*      */ import org.apache.poi.ss.formula.ptg.NamePtg;
/*      */ import org.apache.poi.ss.formula.ptg.NameXPxg;
/*      */ import org.apache.poi.ss.formula.ptg.NotEqualPtg;
/*      */ import org.apache.poi.ss.formula.ptg.NumberPtg;
/*      */ import org.apache.poi.ss.formula.ptg.ParenthesisPtg;
/*      */ import org.apache.poi.ss.formula.ptg.PercentPtg;
/*      */ import org.apache.poi.ss.formula.ptg.PowerPtg;
/*      */ import org.apache.poi.ss.formula.ptg.Ptg;
/*      */ import org.apache.poi.ss.formula.ptg.RangePtg;
/*      */ import org.apache.poi.ss.formula.ptg.RefPtg;
/*      */ import org.apache.poi.ss.formula.ptg.StringPtg;
/*      */ import org.apache.poi.ss.formula.ptg.SubtractPtg;
/*      */ import org.apache.poi.ss.formula.ptg.UnaryMinusPtg;
/*      */ import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;
/*      */ import org.apache.poi.ss.formula.ptg.UnionPtg;
/*      */ import org.apache.poi.ss.formula.ptg.ValueOperatorPtg;
/*      */ import org.apache.poi.ss.usermodel.FormulaError;
/*      */ import org.apache.poi.ss.usermodel.Name;
/*      */ import org.apache.poi.ss.usermodel.Table;
/*      */ import org.apache.poi.ss.util.AreaReference;
/*      */ import org.apache.poi.ss.util.CellReference;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Internal
/*      */ public final class FormulaParser
/*      */ {
/*   96 */   private static final POILogger log = POILogFactory.getLogger(FormulaParser.class);
/*      */ 
/*      */   
/*      */   private final String _formulaString;
/*      */ 
/*      */   
/*      */   private final int _formulaLength;
/*      */ 
/*      */   
/*      */   private int _pointer;
/*      */ 
/*      */   
/*      */   private ParseNode _rootNode;
/*      */   
/*      */   private static final char TAB = '\t';
/*      */   
/*      */   private static final char CR = '\r';
/*      */   
/*      */   private static final char LF = '\n';
/*      */   
/*      */   private char look;
/*      */   
/*      */   private boolean _inIntersection = false;
/*      */   
/*      */   private final FormulaParsingWorkbook _book;
/*      */   
/*      */   private final SpreadsheetVersion _ssVersion;
/*      */   
/*      */   private final int _sheetIndex;
/*      */   
/*      */   private final int _rowIndex;
/*      */   
/*      */   private static final String specHeaders = "Headers";
/*      */   
/*      */   private static final String specAll = "All";
/*      */   
/*      */   private static final String specData = "Data";
/*      */   
/*      */   private static final String specTotals = "Totals";
/*      */   
/*      */   private static final String specThisRow = "This Row";
/*      */ 
/*      */   
/*      */   private FormulaParser(String paramString, FormulaParsingWorkbook paramFormulaParsingWorkbook, int paramInt1, int paramInt2) {
/*  140 */     this._formulaString = paramString;
/*  141 */     this._pointer = 0;
/*  142 */     this._book = paramFormulaParsingWorkbook;
/*  143 */     this._ssVersion = (paramFormulaParsingWorkbook == null) ? SpreadsheetVersion.EXCEL97 : paramFormulaParsingWorkbook.getSpreadsheetVersion();
/*  144 */     this._formulaLength = this._formulaString.length();
/*  145 */     this._sheetIndex = paramInt1;
/*  146 */     this._rowIndex = paramInt2;
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
/*      */   public static Ptg[] parse(String paramString, FormulaParsingWorkbook paramFormulaParsingWorkbook, FormulaType paramFormulaType, int paramInt1, int paramInt2) {
/*  169 */     FormulaParser formulaParser = new FormulaParser(paramString, paramFormulaParsingWorkbook, paramInt1, paramInt2);
/*  170 */     formulaParser.parse();
/*  171 */     return formulaParser.getRPNPtg(paramFormulaType);
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
/*      */   public static Ptg[] parse(String paramString, FormulaParsingWorkbook paramFormulaParsingWorkbook, FormulaType paramFormulaType, int paramInt) {
/*  190 */     return parse(paramString, paramFormulaParsingWorkbook, paramFormulaType, paramInt, -1);
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
/*      */   public static Area3DPxg parseStructuredReference(String paramString, FormulaParsingWorkbook paramFormulaParsingWorkbook, int paramInt) {
/*  203 */     byte b = -1;
/*  204 */     Ptg[] arrayOfPtg = parse(paramString, paramFormulaParsingWorkbook, FormulaType.CELL, -1, paramInt);
/*  205 */     if (arrayOfPtg.length != 1 || !(arrayOfPtg[0] instanceof Area3DPxg)) {
/*  206 */       throw new IllegalStateException("Illegal structured reference");
/*      */     }
/*  208 */     return (Area3DPxg)arrayOfPtg[0];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void GetChar() {
/*  215 */     if (IsWhite(this.look)) {
/*  216 */       if (this.look == ' ') {
/*  217 */         this._inIntersection = true;
/*      */       }
/*      */     } else {
/*      */       
/*  221 */       this._inIntersection = false;
/*      */     } 
/*      */ 
/*      */     
/*  225 */     if (this._pointer > this._formulaLength) {
/*  226 */       throw new RuntimeException("too far");
/*      */     }
/*  228 */     if (this._pointer < this._formulaLength) {
/*  229 */       this.look = this._formulaString.charAt(this._pointer);
/*      */     }
/*      */     else {
/*      */       
/*  233 */       this.look = Character.MIN_VALUE;
/*  234 */       this._inIntersection = false;
/*      */     } 
/*  236 */     this._pointer++;
/*      */   }
/*      */   
/*      */   private void resetPointer(int paramInt) {
/*  240 */     this._pointer = paramInt;
/*  241 */     if (this._pointer <= this._formulaLength) {
/*  242 */       this.look = this._formulaString.charAt(this._pointer - 1);
/*      */     }
/*      */     else {
/*      */       
/*  246 */       this.look = Character.MIN_VALUE;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private RuntimeException expected(String paramString) {
/*      */     String str;
/*  254 */     if (this.look == '=' && this._formulaString.substring(0, this._pointer - 1).trim().length() < 1) {
/*  255 */       str = "The specified formula '" + this._formulaString + "' starts with an equals sign which is not allowed.";
/*      */     } else {
/*      */       
/*  258 */       str = "Parse error near char " + (this._pointer - 1) + " '" + this.look + "'" + " in specified formula '" + this._formulaString + "'. Expected " + paramString;
/*      */     } 
/*      */ 
/*      */     
/*  262 */     return new FormulaParseException(str);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean IsAlpha(char paramChar) {
/*  267 */     return (Character.isLetter(paramChar) || paramChar == '$' || paramChar == '_');
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean IsDigit(char paramChar) {
/*  272 */     return Character.isDigit(paramChar);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean IsWhite(char paramChar) {
/*  277 */     return (paramChar == ' ' || paramChar == '\t' || paramChar == '\r' || paramChar == '\n');
/*      */   }
/*      */ 
/*      */   
/*      */   private void SkipWhite() {
/*  282 */     while (IsWhite(this.look)) {
/*  283 */       GetChar();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void Match(char paramChar) {
/*  293 */     if (this.look != paramChar) {
/*  294 */       throw expected("'" + paramChar + "'");
/*      */     }
/*  296 */     GetChar();
/*      */   }
/*      */ 
/*      */   
/*      */   private String GetNum() {
/*  301 */     StringBuffer stringBuffer = new StringBuffer();
/*      */     
/*  303 */     while (IsDigit(this.look)) {
/*  304 */       stringBuffer.append(this.look);
/*  305 */       GetChar();
/*      */     } 
/*  307 */     return (stringBuffer.length() == 0) ? null : stringBuffer.toString();
/*      */   }
/*      */   
/*      */   private ParseNode parseRangeExpression() {
/*  311 */     ParseNode parseNode = parseRangeable();
/*  312 */     boolean bool = false;
/*  313 */     while (this.look == ':') {
/*  314 */       int i = this._pointer;
/*  315 */       GetChar();
/*  316 */       ParseNode parseNode1 = parseRangeable();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  322 */       checkValidRangeOperand("LHS", i, parseNode);
/*  323 */       checkValidRangeOperand("RHS", i, parseNode1);
/*      */       
/*  325 */       ParseNode[] arrayOfParseNode = { parseNode, parseNode1 };
/*  326 */       parseNode = new ParseNode((Ptg)RangePtg.instance, arrayOfParseNode);
/*  327 */       bool = true;
/*      */     } 
/*  329 */     if (bool) {
/*  330 */       return augmentWithMemPtg(parseNode);
/*      */     }
/*  332 */     return parseNode;
/*      */   }
/*      */   
/*      */   private static ParseNode augmentWithMemPtg(ParseNode paramParseNode) {
/*      */     MemAreaPtg memAreaPtg;
/*  337 */     if (needsMemFunc(paramParseNode)) {
/*  338 */       MemFuncPtg memFuncPtg = new MemFuncPtg(paramParseNode.getEncodedSize());
/*      */     } else {
/*  340 */       memAreaPtg = new MemAreaPtg(paramParseNode.getEncodedSize());
/*      */     } 
/*  342 */     return new ParseNode((Ptg)memAreaPtg, paramParseNode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean needsMemFunc(ParseNode paramParseNode) {
/*  351 */     Ptg ptg = paramParseNode.getToken();
/*  352 */     if (ptg instanceof AbstractFunctionPtg) {
/*  353 */       return true;
/*      */     }
/*  355 */     if (ptg instanceof ExternSheetReferenceToken) {
/*  356 */       return true;
/*      */     }
/*  358 */     if (ptg instanceof NamePtg || ptg instanceof org.apache.poi.ss.formula.ptg.NameXPtg) {
/*  359 */       return true;
/*      */     }
/*      */     
/*  362 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.OperationPtg || ptg instanceof ParenthesisPtg) {
/*      */       
/*  364 */       for (ParseNode parseNode : paramParseNode.getChildren()) {
/*  365 */         if (needsMemFunc(parseNode)) {
/*  366 */           return true;
/*      */         }
/*      */       } 
/*  369 */       return false;
/*      */     } 
/*  371 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.OperandPtg) {
/*  372 */       return false;
/*      */     }
/*  374 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.OperationPtg) {
/*  375 */       return true;
/*      */     }
/*      */     
/*  378 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkValidRangeOperand(String paramString, int paramInt, ParseNode paramParseNode) {
/*  385 */     if (!isValidRangeOperand(paramParseNode)) {
/*  386 */       throw new FormulaParseException("The " + paramString + " of the range operator ':' at position " + paramInt + " is not a proper reference.");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isValidRangeOperand(ParseNode paramParseNode) {
/*  397 */     Ptg ptg = paramParseNode.getToken();
/*      */     
/*  399 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.OperandPtg)
/*      */     {
/*  401 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  405 */     if (ptg instanceof AbstractFunctionPtg) {
/*  406 */       AbstractFunctionPtg abstractFunctionPtg = (AbstractFunctionPtg)ptg;
/*  407 */       byte b = abstractFunctionPtg.getDefaultOperandClass();
/*  408 */       return (0 == b);
/*      */     } 
/*  410 */     if (ptg instanceof ValueOperatorPtg) {
/*  411 */       return false;
/*      */     }
/*  413 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.OperationPtg) {
/*  414 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  418 */     if (ptg instanceof ParenthesisPtg)
/*      */     {
/*  420 */       return isValidRangeOperand(paramParseNode.getChildren()[0]);
/*      */     }
/*      */ 
/*      */     
/*  424 */     if (ptg == ErrPtg.REF_INVALID) {
/*  425 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  429 */     return false;
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
/*      */   private ParseNode parseRangeable() {
/*  459 */     SkipWhite();
/*  460 */     int i = this._pointer;
/*  461 */     SheetIdentifier sheetIdentifier = parseSheetName();
/*      */     
/*  463 */     if (sheetIdentifier == null) {
/*  464 */       resetPointer(i);
/*      */     } else {
/*  466 */       SkipWhite();
/*  467 */       i = this._pointer;
/*      */     } 
/*      */     
/*  470 */     SimpleRangePart simpleRangePart = parseSimpleRangePart();
/*  471 */     if (simpleRangePart == null) {
/*  472 */       if (sheetIdentifier != null) {
/*  473 */         if (this.look == '#') {
/*  474 */           return new ParseNode((Ptg)ErrPtg.valueOf(parseErrorLiteral()));
/*      */         }
/*      */         
/*  477 */         String str = parseAsName();
/*  478 */         if (str.length() == 0) {
/*  479 */           throw new FormulaParseException("Cell reference or Named Range expected after sheet name at index " + this._pointer + ".");
/*      */         }
/*      */         
/*  482 */         Ptg ptg = this._book.getNameXPtg(str, sheetIdentifier);
/*  483 */         if (ptg == null) {
/*  484 */           throw new FormulaParseException("Specified name '" + str + "' for sheet " + sheetIdentifier.asFormulaString() + " not found");
/*      */         }
/*      */         
/*  487 */         return new ParseNode(ptg);
/*      */       } 
/*      */       
/*  490 */       return parseNonRange(i);
/*      */     } 
/*  492 */     boolean bool = IsWhite(this.look);
/*  493 */     if (bool) {
/*  494 */       SkipWhite();
/*      */     }
/*      */     
/*  497 */     if (this.look == ':') {
/*  498 */       int j = this._pointer;
/*  499 */       GetChar();
/*  500 */       SkipWhite();
/*  501 */       SimpleRangePart simpleRangePart1 = parseSimpleRangePart();
/*  502 */       if (simpleRangePart1 != null && !simpleRangePart.isCompatibleForArea(simpleRangePart1))
/*      */       {
/*      */ 
/*      */         
/*  506 */         simpleRangePart1 = null;
/*      */       }
/*  508 */       if (simpleRangePart1 == null) {
/*      */ 
/*      */         
/*  511 */         resetPointer(j);
/*  512 */         if (!simpleRangePart.isCell()) {
/*  513 */           String str = "";
/*  514 */           if (sheetIdentifier != null) {
/*  515 */             str = "'" + sheetIdentifier.getSheetIdentifier().getName() + '!';
/*      */           }
/*  517 */           throw new FormulaParseException(str + simpleRangePart.getRep() + "' is not a proper reference.");
/*      */         } 
/*      */       } 
/*  520 */       return createAreaRefParseNode(sheetIdentifier, simpleRangePart, simpleRangePart1);
/*      */     } 
/*      */     
/*  523 */     if (this.look == '.') {
/*  524 */       GetChar();
/*  525 */       byte b = 1;
/*  526 */       while (this.look == '.') {
/*  527 */         b++;
/*  528 */         GetChar();
/*      */       } 
/*  530 */       boolean bool1 = IsWhite(this.look);
/*      */       
/*  532 */       SkipWhite();
/*  533 */       SimpleRangePart simpleRangePart1 = parseSimpleRangePart();
/*  534 */       String str = this._formulaString.substring(i - 1, this._pointer - 1);
/*  535 */       if (simpleRangePart1 == null) {
/*  536 */         if (sheetIdentifier != null) {
/*  537 */           throw new FormulaParseException("Complete area reference expected after sheet name at index " + this._pointer + ".");
/*      */         }
/*      */         
/*  540 */         return parseNonRange(i);
/*      */       } 
/*      */ 
/*      */       
/*  544 */       if (bool || bool1) {
/*  545 */         if (simpleRangePart.isRowOrColumn() || simpleRangePart1.isRowOrColumn())
/*      */         {
/*      */           
/*  548 */           throw new FormulaParseException("Dotted range (full row or column) expression '" + str + "' must not contain whitespace.");
/*      */         }
/*      */         
/*  551 */         return createAreaRefParseNode(sheetIdentifier, simpleRangePart, simpleRangePart1);
/*      */       } 
/*      */       
/*  554 */       if (b == 1 && simpleRangePart.isRow() && simpleRangePart1.isRow())
/*      */       {
/*  556 */         return parseNonRange(i);
/*      */       }
/*      */       
/*  559 */       if ((simpleRangePart.isRowOrColumn() || simpleRangePart1.isRowOrColumn()) && 
/*  560 */         b != 2) {
/*  561 */         throw new FormulaParseException("Dotted range (full row or column) expression '" + str + "' must have exactly 2 dots.");
/*      */       }
/*      */ 
/*      */       
/*  565 */       return createAreaRefParseNode(sheetIdentifier, simpleRangePart, simpleRangePart1);
/*      */     } 
/*  567 */     if (simpleRangePart.isCell() && isValidCellReference(simpleRangePart.getRep())) {
/*  568 */       return createAreaRefParseNode(sheetIdentifier, simpleRangePart, null);
/*      */     }
/*  570 */     if (sheetIdentifier != null) {
/*  571 */       throw new FormulaParseException("Second part of cell reference expected after sheet name at index " + this._pointer + ".");
/*      */     }
/*      */ 
/*      */     
/*  575 */     return parseNonRange(i);
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
/*      */   private ParseNode parseStructuredReference(String paramString) {
/*  614 */     if (!this._ssVersion.equals(SpreadsheetVersion.EXCEL2007)) {
/*  615 */       throw new FormulaParseException("Structured references work only on XSSF (Excel 2007+)!");
/*      */     }
/*  617 */     Table table = this._book.getTable(paramString);
/*  618 */     if (table == null) {
/*  619 */       throw new FormulaParseException("Illegal table name: '" + paramString + "'");
/*      */     }
/*  621 */     String str1 = table.getSheetName();
/*      */     
/*  623 */     int i = table.getStartColIndex();
/*  624 */     int j = table.getEndColIndex();
/*  625 */     int k = table.getStartRowIndex();
/*  626 */     int m = table.getEndRowIndex();
/*      */ 
/*      */ 
/*      */     
/*  630 */     int n = this._pointer;
/*  631 */     GetChar();
/*      */     
/*  633 */     boolean bool1 = false;
/*  634 */     boolean bool2 = false;
/*  635 */     boolean bool3 = false;
/*  636 */     boolean bool4 = false;
/*  637 */     boolean bool5 = false;
/*  638 */     byte b1 = 0;
/*      */     while (true) {
/*  640 */       int i6 = this._pointer;
/*  641 */       String str = parseAsSpecialQuantifier();
/*  642 */       if (str == null) {
/*  643 */         resetPointer(i6);
/*      */         break;
/*      */       } 
/*  646 */       if (str.equals("All")) {
/*  647 */         bool5 = true;
/*  648 */       } else if (str.equals("Data")) {
/*  649 */         bool3 = true;
/*  650 */       } else if (str.equals("Headers")) {
/*  651 */         bool4 = true;
/*  652 */       } else if (str.equals("This Row")) {
/*  653 */         bool2 = true;
/*  654 */       } else if (str.equals("Totals")) {
/*  655 */         bool1 = true;
/*      */       } else {
/*  657 */         throw new FormulaParseException("Unknown special quantifier " + str);
/*      */       } 
/*  659 */       b1++;
/*  660 */       if (this.look == ',') {
/*  661 */         GetChar();
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  666 */     boolean bool6 = false;
/*  667 */     SkipWhite();
/*  668 */     if (this.look == '@') {
/*  669 */       bool6 = true;
/*  670 */       GetChar();
/*      */     } 
/*      */     
/*  673 */     String str2 = null;
/*  674 */     String str3 = null;
/*  675 */     byte b2 = 0;
/*  676 */     int i1 = this._pointer;
/*  677 */     str2 = parseAsColumnQuantifier();
/*  678 */     if (str2 == null) {
/*  679 */       resetPointer(i1);
/*      */     } else {
/*  681 */       b2++;
/*  682 */       if (this.look == ',')
/*  683 */         throw new FormulaParseException("The formula " + this._formulaString + "is illegal: you should not use ',' with column quantifiers"); 
/*  684 */       if (this.look == ':') {
/*  685 */         GetChar();
/*  686 */         str3 = parseAsColumnQuantifier();
/*  687 */         b2++;
/*  688 */         if (str3 == null) {
/*  689 */           throw new FormulaParseException("The formula " + this._formulaString + "is illegal: the string after ':' must be column quantifier");
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  694 */     if (b2 == 0 && b1 == 0) {
/*  695 */       resetPointer(n);
/*  696 */       n = this._pointer;
/*  697 */       str2 = parseAsColumnQuantifier();
/*  698 */       if (str2 != null) {
/*  699 */         b2++;
/*      */       } else {
/*  701 */         resetPointer(n);
/*  702 */         String str = parseAsSpecialQuantifier();
/*  703 */         if (str != null) {
/*  704 */           if (str.equals("All")) {
/*  705 */             bool5 = true;
/*  706 */           } else if (str.equals("Data")) {
/*  707 */             bool3 = true;
/*  708 */           } else if (str.equals("Headers")) {
/*  709 */             bool4 = true;
/*  710 */           } else if (str.equals("This Row")) {
/*  711 */             bool2 = true;
/*  712 */           } else if (str.equals("Totals")) {
/*  713 */             bool1 = true;
/*      */           } else {
/*  715 */             throw new FormulaParseException("Unknown special quantifier " + str);
/*      */           } 
/*  717 */           b1++;
/*      */         } else {
/*  719 */           throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
/*      */         } 
/*      */       } 
/*      */     } else {
/*  723 */       Match(']');
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  728 */     if (bool1 && !table.isHasTotalsRow()) {
/*  729 */       return new ParseNode((Ptg)ErrPtg.REF_INVALID);
/*      */     }
/*  731 */     if ((bool6 || bool2) && (this._rowIndex < k || m < this._rowIndex)) {
/*      */       
/*  733 */       if (this._rowIndex >= 0) {
/*  734 */         return new ParseNode((Ptg)ErrPtg.VALUE_INVALID);
/*      */       }
/*  736 */       throw new FormulaParseException("Formula contained [#This Row] or [@] structured reference but this row < 0. Row index must be specified for row-referencing structured references.");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  742 */     int i2 = k;
/*  743 */     int i3 = m;
/*  744 */     int i4 = i;
/*  745 */     int i5 = j;
/*  746 */     if (b1 > 0) {
/*      */       
/*  748 */       if (b1 != 1 || !bool5)
/*      */       {
/*  750 */         if (bool3 && bool4) {
/*  751 */           if (table.isHasTotalsRow()) {
/*  752 */             i3 = m - 1;
/*      */           }
/*  754 */         } else if (bool3 && bool1) {
/*  755 */           i2 = k + 1;
/*  756 */         } else if (b1 == 1 && bool3) {
/*  757 */           i2 = k + 1;
/*  758 */           if (table.isHasTotalsRow()) {
/*  759 */             i3 = m - 1;
/*      */           }
/*  761 */         } else if (b1 == 1 && bool4) {
/*  762 */           i3 = i2;
/*  763 */         } else if (b1 == 1 && bool1) {
/*  764 */           i2 = i3;
/*  765 */         } else if ((b1 == 1 && bool2) || bool6) {
/*  766 */           i2 = this._rowIndex;
/*  767 */           i3 = this._rowIndex;
/*      */         } else {
/*  769 */           throw new FormulaParseException("The formula " + this._formulaString + " is illegal");
/*      */         } 
/*      */       }
/*  772 */     } else if (bool6) {
/*  773 */       i2 = this._rowIndex;
/*  774 */       i3 = this._rowIndex;
/*      */     } else {
/*  776 */       i2++;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  782 */     if (b2 == 2) {
/*  783 */       if (str2 == null || str3 == null) {
/*  784 */         throw new IllegalStateException("Fatal error");
/*      */       }
/*  786 */       int i6 = table.findColumnIndex(str2);
/*  787 */       int i7 = table.findColumnIndex(str3);
/*  788 */       if (i6 == -1 || i7 == -1) {
/*  789 */         throw new FormulaParseException("One of the columns " + str2 + ", " + str3 + " doesn't exist in table " + table.getName());
/*      */       }
/*  791 */       i4 = i + i6;
/*  792 */       i5 = i + i7;
/*      */     }
/*  794 */     else if (b2 == 1 && !bool6) {
/*  795 */       if (str2 == null) {
/*  796 */         throw new IllegalStateException("Fatal error");
/*      */       }
/*  798 */       int i6 = table.findColumnIndex(str2);
/*  799 */       if (i6 == -1) {
/*  800 */         throw new FormulaParseException("The column " + str2 + " doesn't exist in table " + table.getName());
/*      */       }
/*  802 */       i4 = i + i6;
/*  803 */       i5 = i4;
/*      */     } 
/*  805 */     CellReference cellReference1 = new CellReference(i2, i4);
/*  806 */     CellReference cellReference2 = new CellReference(i3, i5);
/*  807 */     SheetIdentifier sheetIdentifier = new SheetIdentifier(null, new NameIdentifier(str1, true));
/*  808 */     Ptg ptg = this._book.get3DReferencePtg(new AreaReference(cellReference1, cellReference2), sheetIdentifier);
/*  809 */     return new ParseNode(ptg);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String parseAsColumnQuantifier() {
/*  817 */     if (this.look != '[') {
/*  818 */       return null;
/*      */     }
/*  820 */     GetChar();
/*  821 */     if (this.look == '#') {
/*  822 */       return null;
/*      */     }
/*  824 */     if (this.look == '@') {
/*  825 */       GetChar();
/*      */     }
/*  827 */     StringBuilder stringBuilder = new StringBuilder();
/*  828 */     while (this.look != ']') {
/*  829 */       stringBuilder.append(this.look);
/*  830 */       GetChar();
/*      */     } 
/*  832 */     Match(']');
/*  833 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String parseAsSpecialQuantifier() {
/*  840 */     if (this.look != '[') {
/*  841 */       return null;
/*      */     }
/*  843 */     GetChar();
/*  844 */     if (this.look != '#') {
/*  845 */       return null;
/*      */     }
/*  847 */     GetChar();
/*  848 */     String str = parseAsName();
/*  849 */     if (str.equals("This")) {
/*  850 */       str = str + ' ' + parseAsName();
/*      */     }
/*  852 */     Match(']');
/*  853 */     return str;
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
/*      */   private ParseNode parseNonRange(int paramInt) {
/*  870 */     resetPointer(paramInt);
/*      */     
/*  872 */     if (Character.isDigit(this.look)) {
/*  873 */       return new ParseNode(parseNumber());
/*      */     }
/*  875 */     if (this.look == '"') {
/*  876 */       return new ParseNode((Ptg)new StringPtg(parseStringLiteral()));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  881 */     String str = parseAsName();
/*      */     
/*  883 */     if (this.look == '(') {
/*  884 */       return function(str);
/*      */     }
/*  886 */     if (this.look == '[') {
/*  887 */       return parseStructuredReference(str);
/*      */     }
/*  889 */     if (str.equalsIgnoreCase("TRUE") || str.equalsIgnoreCase("FALSE")) {
/*  890 */       return new ParseNode((Ptg)BoolPtg.valueOf(str.equalsIgnoreCase("TRUE")));
/*      */     }
/*  892 */     if (this._book == null)
/*      */     {
/*  894 */       throw new IllegalStateException("Need book to evaluate name '" + str + "'");
/*      */     }
/*  896 */     EvaluationName evaluationName = this._book.getName(str, this._sheetIndex);
/*  897 */     if (evaluationName == null) {
/*  898 */       throw new FormulaParseException("Specified named range '" + str + "' does not exist in the current workbook.");
/*      */     }
/*      */     
/*  901 */     if (evaluationName.isRange()) {
/*  902 */       return new ParseNode((Ptg)evaluationName.createPtg());
/*      */     }
/*      */     
/*  905 */     throw new FormulaParseException("Specified name '" + str + "' is not a range as expected.");
/*      */   }
/*      */ 
/*      */   
/*      */   private String parseAsName() {
/*  910 */     StringBuilder stringBuilder = new StringBuilder();
/*      */ 
/*      */     
/*  913 */     if (!Character.isLetter(this.look) && this.look != '_' && this.look != '\\') {
/*  914 */       throw expected("number, string, defined name, or data table");
/*      */     }
/*  916 */     while (isValidDefinedNameChar(this.look)) {
/*  917 */       stringBuilder.append(this.look);
/*  918 */       GetChar();
/*      */     } 
/*  920 */     SkipWhite();
/*      */     
/*  922 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isValidDefinedNameChar(char paramChar) {
/*  930 */     if (Character.isLetterOrDigit(paramChar)) {
/*  931 */       return true;
/*      */     }
/*  933 */     switch (paramChar) {
/*      */       case '.':
/*      */       case '?':
/*      */       case '\\':
/*      */       case '_':
/*  938 */         return true;
/*      */     } 
/*  940 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ParseNode createAreaRefParseNode(SheetIdentifier paramSheetIdentifier, SimpleRangePart paramSimpleRangePart1, SimpleRangePart paramSimpleRangePart2) throws FormulaParseException {
/*      */     Ptg ptg;
/*  952 */     if (paramSimpleRangePart2 == null) {
/*  953 */       CellReference cellReference = paramSimpleRangePart1.getCellReference();
/*  954 */       if (paramSheetIdentifier == null) {
/*  955 */         RefPtg refPtg = new RefPtg(cellReference);
/*      */       } else {
/*  957 */         ptg = this._book.get3DReferencePtg(cellReference, paramSheetIdentifier);
/*      */       } 
/*      */     } else {
/*  960 */       AreaReference areaReference = createAreaRef(paramSimpleRangePart1, paramSimpleRangePart2);
/*      */       
/*  962 */       if (paramSheetIdentifier == null) {
/*  963 */         AreaPtg areaPtg = new AreaPtg(areaReference);
/*      */       } else {
/*  965 */         ptg = this._book.get3DReferencePtg(areaReference, paramSheetIdentifier);
/*      */       } 
/*      */     } 
/*  968 */     return new ParseNode(ptg);
/*      */   }
/*      */   
/*      */   private AreaReference createAreaRef(SimpleRangePart paramSimpleRangePart1, SimpleRangePart paramSimpleRangePart2) {
/*  972 */     if (!paramSimpleRangePart1.isCompatibleForArea(paramSimpleRangePart2)) {
/*  973 */       throw new FormulaParseException("has incompatible parts: '" + paramSimpleRangePart1.getRep() + "' and '" + paramSimpleRangePart2.getRep() + "'.");
/*      */     }
/*      */     
/*  976 */     if (paramSimpleRangePart1.isRow()) {
/*  977 */       return AreaReference.getWholeRow(this._ssVersion, paramSimpleRangePart1.getRep(), paramSimpleRangePart2.getRep());
/*      */     }
/*  979 */     if (paramSimpleRangePart1.isColumn()) {
/*  980 */       return AreaReference.getWholeColumn(this._ssVersion, paramSimpleRangePart1.getRep(), paramSimpleRangePart2.getRep());
/*      */     }
/*  982 */     return new AreaReference(paramSimpleRangePart1.getCellReference(), paramSimpleRangePart2.getCellReference());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  990 */   private static final Pattern CELL_REF_PATTERN = Pattern.compile("(\\$?[A-Za-z]+)?(\\$?[0-9]+)?");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private SimpleRangePart parseSimpleRangePart() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield _pointer : I
/*      */     //   4: iconst_1
/*      */     //   5: isub
/*      */     //   6: istore_1
/*      */     //   7: iconst_0
/*      */     //   8: istore_2
/*      */     //   9: iconst_0
/*      */     //   10: istore_3
/*      */     //   11: iload_1
/*      */     //   12: aload_0
/*      */     //   13: getfield _formulaLength : I
/*      */     //   16: if_icmpge -> 75
/*      */     //   19: aload_0
/*      */     //   20: getfield _formulaString : Ljava/lang/String;
/*      */     //   23: iload_1
/*      */     //   24: invokevirtual charAt : (I)C
/*      */     //   27: istore #4
/*      */     //   29: iload #4
/*      */     //   31: invokestatic isDigit : (C)Z
/*      */     //   34: ifeq -> 42
/*      */     //   37: iconst_1
/*      */     //   38: istore_2
/*      */     //   39: goto -> 69
/*      */     //   42: iload #4
/*      */     //   44: invokestatic isLetter : (C)Z
/*      */     //   47: ifeq -> 55
/*      */     //   50: iconst_1
/*      */     //   51: istore_3
/*      */     //   52: goto -> 69
/*      */     //   55: iload #4
/*      */     //   57: bipush #36
/*      */     //   59: if_icmpeq -> 69
/*      */     //   62: iload #4
/*      */     //   64: bipush #95
/*      */     //   66: if_icmpne -> 75
/*      */     //   69: iinc #1, 1
/*      */     //   72: goto -> 11
/*      */     //   75: iload_1
/*      */     //   76: aload_0
/*      */     //   77: getfield _pointer : I
/*      */     //   80: iconst_1
/*      */     //   81: isub
/*      */     //   82: if_icmpgt -> 87
/*      */     //   85: aconst_null
/*      */     //   86: areturn
/*      */     //   87: aload_0
/*      */     //   88: getfield _formulaString : Ljava/lang/String;
/*      */     //   91: aload_0
/*      */     //   92: getfield _pointer : I
/*      */     //   95: iconst_1
/*      */     //   96: isub
/*      */     //   97: iload_1
/*      */     //   98: invokevirtual substring : (II)Ljava/lang/String;
/*      */     //   101: astore #4
/*      */     //   103: getstatic org/apache/poi/ss/formula/FormulaParser.CELL_REF_PATTERN : Ljava/util/regex/Pattern;
/*      */     //   106: aload #4
/*      */     //   108: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
/*      */     //   111: invokevirtual matches : ()Z
/*      */     //   114: ifne -> 119
/*      */     //   117: aconst_null
/*      */     //   118: areturn
/*      */     //   119: iload_3
/*      */     //   120: ifeq -> 138
/*      */     //   123: iload_2
/*      */     //   124: ifeq -> 138
/*      */     //   127: aload_0
/*      */     //   128: aload #4
/*      */     //   130: invokespecial isValidCellReference : (Ljava/lang/String;)Z
/*      */     //   133: ifne -> 213
/*      */     //   136: aconst_null
/*      */     //   137: areturn
/*      */     //   138: iload_3
/*      */     //   139: ifeq -> 163
/*      */     //   142: aload #4
/*      */     //   144: ldc '$'
/*      */     //   146: ldc ''
/*      */     //   148: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*      */     //   151: aload_0
/*      */     //   152: getfield _ssVersion : Lorg/apache/poi/ss/SpreadsheetVersion;
/*      */     //   155: invokestatic isColumnWithinRange : (Ljava/lang/String;Lorg/apache/poi/ss/SpreadsheetVersion;)Z
/*      */     //   158: ifne -> 213
/*      */     //   161: aconst_null
/*      */     //   162: areturn
/*      */     //   163: iload_2
/*      */     //   164: ifeq -> 211
/*      */     //   167: aload #4
/*      */     //   169: ldc '$'
/*      */     //   171: ldc ''
/*      */     //   173: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
/*      */     //   176: invokestatic parseInt : (Ljava/lang/String;)I
/*      */     //   179: istore #5
/*      */     //   181: goto -> 188
/*      */     //   184: astore #6
/*      */     //   186: aconst_null
/*      */     //   187: areturn
/*      */     //   188: iload #5
/*      */     //   190: iconst_1
/*      */     //   191: if_icmplt -> 206
/*      */     //   194: iload #5
/*      */     //   196: aload_0
/*      */     //   197: getfield _ssVersion : Lorg/apache/poi/ss/SpreadsheetVersion;
/*      */     //   200: invokevirtual getMaxRows : ()I
/*      */     //   203: if_icmple -> 208
/*      */     //   206: aconst_null
/*      */     //   207: areturn
/*      */     //   208: goto -> 213
/*      */     //   211: aconst_null
/*      */     //   212: areturn
/*      */     //   213: aload_0
/*      */     //   214: iload_1
/*      */     //   215: iconst_1
/*      */     //   216: iadd
/*      */     //   217: invokespecial resetPointer : (I)V
/*      */     //   220: new org/apache/poi/ss/formula/FormulaParser$SimpleRangePart
/*      */     //   223: dup
/*      */     //   224: aload #4
/*      */     //   226: iload_3
/*      */     //   227: iload_2
/*      */     //   228: invokespecial <init> : (Ljava/lang/String;ZZ)V
/*      */     //   231: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #998	-> 0
/*      */     //   #999	-> 7
/*      */     //   #1000	-> 9
/*      */     //   #1001	-> 11
/*      */     //   #1002	-> 19
/*      */     //   #1003	-> 29
/*      */     //   #1004	-> 37
/*      */     //   #1005	-> 42
/*      */     //   #1006	-> 50
/*      */     //   #1007	-> 55
/*      */     //   #1012	-> 69
/*      */     //   #1013	-> 72
/*      */     //   #1014	-> 75
/*      */     //   #1015	-> 85
/*      */     //   #1017	-> 87
/*      */     //   #1018	-> 103
/*      */     //   #1019	-> 117
/*      */     //   #1022	-> 119
/*      */     //   #1023	-> 127
/*      */     //   #1024	-> 136
/*      */     //   #1026	-> 138
/*      */     //   #1027	-> 142
/*      */     //   #1028	-> 161
/*      */     //   #1030	-> 163
/*      */     //   #1033	-> 167
/*      */     //   #1036	-> 181
/*      */     //   #1034	-> 184
/*      */     //   #1035	-> 186
/*      */     //   #1037	-> 188
/*      */     //   #1038	-> 206
/*      */     //   #1040	-> 208
/*      */     //   #1042	-> 211
/*      */     //   #1046	-> 213
/*      */     //   #1047	-> 220
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   167	181	184	java/lang/NumberFormatException
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
/*      */   private static final class SimpleRangePart
/*      */   {
/*      */     private final Type _type;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final String _rep;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private enum Type
/*      */     {
/* 1056 */       CELL, ROW, COLUMN;
/*      */       
/*      */       public static Type get(boolean param2Boolean1, boolean param2Boolean2) {
/* 1059 */         if (param2Boolean1) {
/* 1060 */           return param2Boolean2 ? CELL : COLUMN;
/*      */         }
/* 1062 */         if (!param2Boolean2) {
/* 1063 */           throw new IllegalArgumentException("must have either letters or numbers");
/*      */         }
/* 1065 */         return ROW;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SimpleRangePart(String param1String, boolean param1Boolean1, boolean param1Boolean2) {
/* 1073 */       this._rep = param1String;
/* 1074 */       this._type = Type.get(param1Boolean1, param1Boolean2);
/*      */     }
/*      */     
/*      */     public boolean isCell() {
/* 1078 */       return (this._type == Type.CELL);
/*      */     }
/*      */     
/*      */     public boolean isRowOrColumn() {
/* 1082 */       return (this._type != Type.CELL);
/*      */     }
/*      */     
/*      */     public CellReference getCellReference() {
/* 1086 */       if (this._type != Type.CELL) {
/* 1087 */         throw new IllegalStateException("Not applicable to this type");
/*      */       }
/* 1089 */       return new CellReference(this._rep);
/*      */     }
/*      */     
/*      */     public boolean isColumn() {
/* 1093 */       return (this._type == Type.COLUMN);
/*      */     }
/*      */     
/*      */     public boolean isRow() {
/* 1097 */       return (this._type == Type.ROW);
/*      */     }
/*      */     
/*      */     public String getRep() {
/* 1101 */       return this._rep;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isCompatibleForArea(SimpleRangePart param1SimpleRangePart) {
/* 1110 */       return (this._type == param1SimpleRangePart._type);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1115 */       StringBuilder stringBuilder = new StringBuilder(64);
/* 1116 */       stringBuilder.append(getClass().getName()).append(" [");
/* 1117 */       stringBuilder.append(this._rep);
/* 1118 */       stringBuilder.append("]");
/* 1119 */       return stringBuilder.toString();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private SheetIdentifier parseSheetName() {
/*      */     String str;
/* 1129 */     if (this.look == '[') {
/* 1130 */       StringBuilder stringBuilder = new StringBuilder();
/* 1131 */       GetChar();
/* 1132 */       while (this.look != ']') {
/* 1133 */         stringBuilder.append(this.look);
/* 1134 */         GetChar();
/*      */       } 
/* 1136 */       GetChar();
/* 1137 */       str = stringBuilder.toString();
/*      */     } else {
/* 1139 */       str = null;
/*      */     } 
/*      */     
/* 1142 */     if (this.look == '\'') {
/* 1143 */       StringBuffer stringBuffer = new StringBuffer();
/*      */       
/* 1145 */       Match('\'');
/* 1146 */       boolean bool = (this.look == '\'') ? true : false;
/* 1147 */       while (!bool) {
/* 1148 */         stringBuffer.append(this.look);
/* 1149 */         GetChar();
/* 1150 */         if (this.look == '\'') {
/*      */           
/* 1152 */           Match('\'');
/* 1153 */           bool = (this.look != '\'') ? true : false;
/*      */         } 
/*      */       } 
/*      */       
/* 1157 */       NameIdentifier nameIdentifier = new NameIdentifier(stringBuffer.toString(), true);
/*      */       
/* 1159 */       SkipWhite();
/* 1160 */       if (this.look == '!') {
/* 1161 */         GetChar();
/* 1162 */         return new SheetIdentifier(str, nameIdentifier);
/*      */       } 
/*      */       
/* 1165 */       if (this.look == ':') {
/* 1166 */         return parseSheetRange(str, nameIdentifier);
/*      */       }
/* 1168 */       return null;
/*      */     } 
/*      */ 
/*      */     
/* 1172 */     if (this.look == '_' || Character.isLetter(this.look)) {
/* 1173 */       StringBuilder stringBuilder = new StringBuilder();
/*      */       
/* 1175 */       while (isUnquotedSheetNameChar(this.look)) {
/* 1176 */         stringBuilder.append(this.look);
/* 1177 */         GetChar();
/*      */       } 
/* 1179 */       NameIdentifier nameIdentifier = new NameIdentifier(stringBuilder.toString(), false);
/* 1180 */       SkipWhite();
/* 1181 */       if (this.look == '!') {
/* 1182 */         GetChar();
/* 1183 */         return new SheetIdentifier(str, nameIdentifier);
/*      */       } 
/*      */       
/* 1186 */       if (this.look == ':') {
/* 1187 */         return parseSheetRange(str, nameIdentifier);
/*      */       }
/* 1189 */       return null;
/*      */     } 
/* 1191 */     if (this.look == '!' && str != null) {
/*      */       
/* 1193 */       GetChar();
/* 1194 */       return new SheetIdentifier(str, null);
/*      */     } 
/* 1196 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private SheetIdentifier parseSheetRange(String paramString, NameIdentifier paramNameIdentifier) {
/* 1204 */     GetChar();
/* 1205 */     SheetIdentifier sheetIdentifier = parseSheetName();
/* 1206 */     if (sheetIdentifier != null) {
/* 1207 */       return new SheetRangeIdentifier(paramString, paramNameIdentifier, sheetIdentifier.getSheetIdentifier());
/*      */     }
/* 1209 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isUnquotedSheetNameChar(char paramChar) {
/* 1216 */     if (Character.isLetterOrDigit(paramChar)) {
/* 1217 */       return true;
/*      */     }
/* 1219 */     switch (paramChar) {
/*      */       case '.':
/*      */       case '_':
/* 1222 */         return true;
/*      */     } 
/* 1224 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isValidCellReference(String paramString) {
/* 1232 */     boolean bool = (CellReference.classifyCellReference(paramString, this._ssVersion) == CellReference.NameType.CELL) ? true : false;
/*      */     
/* 1234 */     if (bool) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1242 */       boolean bool1 = (FunctionMetadataRegistry.getFunctionByName(paramString.toUpperCase(Locale.ROOT)) != null) ? true : false;
/* 1243 */       if (bool1) {
/* 1244 */         int i = this._pointer;
/* 1245 */         resetPointer(this._pointer + paramString.length());
/* 1246 */         SkipWhite();
/*      */ 
/*      */         
/* 1249 */         bool = (this.look != '(') ? true : false;
/* 1250 */         resetPointer(i);
/*      */       } 
/*      */     } 
/* 1253 */     return bool;
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
/*      */   private ParseNode function(String paramString) {
/*      */     NameXPxg nameXPxg;
/* 1267 */     NamePtg namePtg = null;
/* 1268 */     if (!AbstractFunctionPtg.isBuiltInFunctionName(paramString))
/*      */     
/*      */     { 
/*      */       
/* 1272 */       if (this._book == null)
/*      */       {
/* 1274 */         throw new IllegalStateException("Need book to evaluate name '" + paramString + "'");
/*      */       }
/*      */       
/* 1277 */       EvaluationName evaluationName = this._book.getName(paramString, this._sheetIndex);
/* 1278 */       if (evaluationName != null)
/* 1279 */       { if (!evaluationName.isFunctionName()) {
/* 1280 */           throw new FormulaParseException("Attempt to use name '" + paramString + "' as a function, but defined name in workbook does not refer to a function");
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1286 */         namePtg = evaluationName.createPtg(); }
/*      */       else
/*      */       
/* 1289 */       { Ptg ptg = this._book.getNameXPtg(paramString, null);
/* 1290 */         if (ptg == null)
/*      */         { NamePtg namePtg1; ParseNode[] arrayOfParseNode1;
/* 1292 */           if (log.check(5)) {
/* 1293 */             log.log(5, new Object[] { "FormulaParser.function: Name '" + paramString + "' is completely unknown in the current workbook." });
/*      */           }
/*      */ 
/*      */           
/* 1297 */           switch (this._book.getSpreadsheetVersion())
/*      */           
/*      */           { case EXCEL97:
/* 1300 */               addName(paramString);
/* 1301 */               evaluationName = this._book.getName(paramString, this._sheetIndex);
/* 1302 */               namePtg1 = evaluationName.createPtg();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1315 */               Match('(');
/* 1316 */               arrayOfParseNode1 = Arguments();
/* 1317 */               Match(')');
/*      */               
/* 1319 */               return getFunction(paramString, (Ptg)namePtg1, arrayOfParseNode1);case EXCEL2007: nameXPxg = new NameXPxg(paramString); Match('('); arrayOfParseNode1 = Arguments(); Match(')'); return getFunction(paramString, (Ptg)nameXPxg, arrayOfParseNode1); }  throw new IllegalStateException("Unexpected spreadsheet version: " + this._book.getSpreadsheetVersion().name()); }  }  }  Match('('); ParseNode[] arrayOfParseNode = Arguments(); Match(')'); return getFunction(paramString, (Ptg)nameXPxg, arrayOfParseNode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void addName(String paramString) {
/* 1327 */     Name name = this._book.createName();
/* 1328 */     name.setFunction(true);
/* 1329 */     name.setNameName(paramString);
/* 1330 */     name.setSheetIndex(this._sheetIndex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ParseNode getFunction(String paramString, Ptg paramPtg, ParseNode[] paramArrayOfParseNode) {
/*      */     FuncPtg funcPtg;
/* 1342 */     FunctionMetadata functionMetadata = FunctionMetadataRegistry.getFunctionByName(paramString.toUpperCase(Locale.ROOT));
/* 1343 */     int i = paramArrayOfParseNode.length;
/* 1344 */     if (functionMetadata == null) {
/* 1345 */       if (paramPtg == null) {
/* 1346 */         throw new IllegalStateException("NamePtg must be supplied for external functions");
/*      */       }
/*      */       
/* 1349 */       ParseNode[] arrayOfParseNode = new ParseNode[i + 1];
/* 1350 */       arrayOfParseNode[0] = new ParseNode(paramPtg);
/* 1351 */       System.arraycopy(paramArrayOfParseNode, 0, arrayOfParseNode, 1, i);
/* 1352 */       return new ParseNode((Ptg)FuncVarPtg.create(paramString, i + 1), arrayOfParseNode);
/*      */     } 
/*      */     
/* 1355 */     if (paramPtg != null) {
/* 1356 */       throw new IllegalStateException("NamePtg no applicable to internal functions");
/*      */     }
/* 1358 */     boolean bool = !functionMetadata.hasFixedArgsLength() ? true : false;
/* 1359 */     int j = functionMetadata.getIndex();
/* 1360 */     if (j == 4 && paramArrayOfParseNode.length == 1)
/*      */     {
/*      */       
/* 1363 */       return new ParseNode((Ptg)AttrPtg.getSumSingle(), paramArrayOfParseNode);
/*      */     }
/*      */     
/* 1366 */     validateNumArgs(paramArrayOfParseNode.length, functionMetadata);
/*      */ 
/*      */     
/* 1369 */     if (bool) {
/* 1370 */       FuncVarPtg funcVarPtg = FuncVarPtg.create(paramString, i);
/*      */     } else {
/* 1372 */       funcPtg = FuncPtg.create(j);
/*      */     } 
/* 1374 */     return new ParseNode((Ptg)funcPtg, paramArrayOfParseNode);
/*      */   }
/*      */   private void validateNumArgs(int paramInt, FunctionMetadata paramFunctionMetadata) {
/*      */     int i;
/* 1378 */     if (paramInt < paramFunctionMetadata.getMinParams()) {
/* 1379 */       String str = "Too few arguments to function '" + paramFunctionMetadata.getName() + "'. ";
/* 1380 */       if (paramFunctionMetadata.hasFixedArgsLength()) {
/* 1381 */         str = str + "Expected " + paramFunctionMetadata.getMinParams();
/*      */       } else {
/* 1383 */         str = str + "At least " + paramFunctionMetadata.getMinParams() + " were expected";
/*      */       } 
/* 1385 */       str = str + " but got " + paramInt + ".";
/* 1386 */       throw new FormulaParseException(str);
/*      */     } 
/*      */ 
/*      */     
/* 1390 */     if (paramFunctionMetadata.hasUnlimitedVarags()) {
/* 1391 */       if (this._book != null) {
/* 1392 */         i = this._book.getSpreadsheetVersion().getMaxFunctionArgs();
/*      */       } else {
/*      */         
/* 1395 */         i = paramFunctionMetadata.getMaxParams();
/*      */       } 
/*      */     } else {
/* 1398 */       i = paramFunctionMetadata.getMaxParams();
/*      */     } 
/*      */     
/* 1401 */     if (paramInt > i) {
/* 1402 */       String str = "Too many arguments to function '" + paramFunctionMetadata.getName() + "'. ";
/* 1403 */       if (paramFunctionMetadata.hasFixedArgsLength()) {
/* 1404 */         str = str + "Expected " + i;
/*      */       } else {
/* 1406 */         str = str + "At most " + i + " were expected";
/*      */       } 
/* 1408 */       str = str + " but got " + paramInt + ".";
/* 1409 */       throw new FormulaParseException(str);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static boolean isArgumentDelimiter(char paramChar) {
/* 1414 */     return (paramChar == ',' || paramChar == ')');
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private ParseNode[] Arguments() {
/* 1420 */     ArrayList<ParseNode> arrayList = new ArrayList(2);
/* 1421 */     SkipWhite();
/* 1422 */     if (this.look == ')') {
/* 1423 */       return ParseNode.EMPTY_ARRAY;
/*      */     }
/*      */     
/* 1426 */     boolean bool = true;
/*      */     while (true) {
/* 1428 */       SkipWhite();
/* 1429 */       if (isArgumentDelimiter(this.look)) {
/* 1430 */         if (bool) {
/* 1431 */           arrayList.add(new ParseNode(MissingArgPtg.instance));
/*      */         }
/* 1433 */         if (this.look == ')') {
/*      */           break;
/*      */         }
/* 1436 */         Match(',');
/* 1437 */         bool = true;
/*      */         continue;
/*      */       } 
/* 1440 */       arrayList.add(comparisonExpression());
/* 1441 */       bool = false;
/* 1442 */       SkipWhite();
/* 1443 */       if (!isArgumentDelimiter(this.look)) {
/* 1444 */         throw expected("',' or ')'");
/*      */       }
/*      */     } 
/* 1447 */     ParseNode[] arrayOfParseNode = new ParseNode[arrayList.size()];
/* 1448 */     arrayList.toArray(arrayOfParseNode);
/* 1449 */     return arrayOfParseNode;
/*      */   }
/*      */ 
/*      */   
/*      */   private ParseNode powerFactor() {
/* 1454 */     ParseNode parseNode = percentFactor();
/*      */     while (true) {
/* 1456 */       SkipWhite();
/* 1457 */       if (this.look != '^') {
/* 1458 */         return parseNode;
/*      */       }
/* 1460 */       Match('^');
/* 1461 */       ParseNode parseNode1 = percentFactor();
/* 1462 */       parseNode = new ParseNode((Ptg)PowerPtg.instance, parseNode, parseNode1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private ParseNode percentFactor() {
/* 1467 */     ParseNode parseNode = parseSimpleFactor();
/*      */     while (true) {
/* 1469 */       SkipWhite();
/* 1470 */       if (this.look != '%') {
/* 1471 */         return parseNode;
/*      */       }
/* 1473 */       Match('%');
/* 1474 */       parseNode = new ParseNode((Ptg)PercentPtg.instance, parseNode);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ParseNode parseSimpleFactor() {
/*      */     ParseNode parseNode1, parseNode2;
/* 1483 */     SkipWhite();
/* 1484 */     switch (this.look) {
/*      */       case '#':
/* 1486 */         return new ParseNode((Ptg)ErrPtg.valueOf(parseErrorLiteral()));
/*      */       case '-':
/* 1488 */         Match('-');
/* 1489 */         return parseUnary(false);
/*      */       case '+':
/* 1491 */         Match('+');
/* 1492 */         return parseUnary(true);
/*      */       case '(':
/* 1494 */         Match('(');
/* 1495 */         parseNode1 = unionExpression();
/* 1496 */         Match(')');
/* 1497 */         return new ParseNode((Ptg)ParenthesisPtg.instance, parseNode1);
/*      */       case '"':
/* 1499 */         return new ParseNode((Ptg)new StringPtg(parseStringLiteral()));
/*      */       case '{':
/* 1501 */         Match('{');
/* 1502 */         parseNode2 = parseArray();
/* 1503 */         Match('}');
/* 1504 */         return parseNode2;
/*      */     } 
/*      */ 
/*      */     
/* 1508 */     if (IsAlpha(this.look) || Character.isDigit(this.look) || this.look == '\'' || this.look == '[' || this.look == '_' || this.look == '\\') {
/* 1509 */       return parseRangeExpression();
/*      */     }
/* 1511 */     if (this.look == '.') {
/* 1512 */       return new ParseNode(parseNumber());
/*      */     }
/* 1514 */     throw expected("cell ref or constant literal");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private ParseNode parseUnary(boolean paramBoolean) {
/* 1520 */     boolean bool = (IsDigit(this.look) || this.look == '.') ? true : false;
/* 1521 */     ParseNode parseNode = powerFactor();
/*      */     
/* 1523 */     if (bool) {
/*      */       NumberPtg numberPtg;
/*      */       
/* 1526 */       Ptg ptg = parseNode.getToken();
/* 1527 */       if (ptg instanceof NumberPtg) {
/* 1528 */         if (paramBoolean) {
/* 1529 */           return parseNode;
/*      */         }
/* 1531 */         numberPtg = new NumberPtg(-((NumberPtg)ptg).getValue());
/* 1532 */         return new ParseNode((Ptg)numberPtg);
/*      */       } 
/* 1534 */       if (numberPtg instanceof IntPtg) {
/* 1535 */         if (paramBoolean) {
/* 1536 */           return parseNode;
/*      */         }
/* 1538 */         int i = ((IntPtg)numberPtg).getValue();
/*      */         
/* 1540 */         numberPtg = new NumberPtg(-i);
/* 1541 */         return new ParseNode((Ptg)numberPtg);
/*      */       } 
/*      */     } 
/* 1544 */     return new ParseNode(paramBoolean ? (Ptg)UnaryPlusPtg.instance : (Ptg)UnaryMinusPtg.instance, parseNode);
/*      */   }
/*      */   
/*      */   private ParseNode parseArray() {
/* 1548 */     ArrayList<Object[]> arrayList = new ArrayList();
/*      */     while (true) {
/* 1550 */       Object[] arrayOfObject1 = parseArrayRow();
/* 1551 */       arrayList.add(arrayOfObject1);
/* 1552 */       if (this.look == '}') {
/*      */         break;
/*      */       }
/* 1555 */       if (this.look != ';') {
/* 1556 */         throw expected("'}' or ';'");
/*      */       }
/* 1558 */       Match(';');
/*      */     } 
/* 1560 */     int i = arrayList.size();
/* 1561 */     Object[][] arrayOfObject = new Object[i][];
/* 1562 */     arrayList.toArray(arrayOfObject);
/* 1563 */     int j = (arrayOfObject[0]).length;
/* 1564 */     checkRowLengths(arrayOfObject, j);
/*      */     
/* 1566 */     return new ParseNode((Ptg)new ArrayPtg(arrayOfObject));
/*      */   }
/*      */   private void checkRowLengths(Object[][] paramArrayOfObject, int paramInt) {
/* 1569 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/* 1570 */       int i = (paramArrayOfObject[b]).length;
/* 1571 */       if (i != paramInt) {
/* 1572 */         throw new FormulaParseException("Array row " + b + " has length " + i + " but row 0 has length " + paramInt);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private Object[] parseArrayRow() {
/* 1579 */     ArrayList<Object> arrayList = new ArrayList();
/*      */     while (true) {
/* 1581 */       arrayList.add(parseArrayItem());
/* 1582 */       SkipWhite();
/* 1583 */       switch (this.look) {
/*      */         case ';':
/*      */         case '}':
/*      */           break;
/*      */         case ',':
/* 1588 */           Match(',');
/*      */           continue;
/*      */       } 
/* 1591 */       throw expected("'}' or ','");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1597 */     Object[] arrayOfObject = new Object[arrayList.size()];
/* 1598 */     arrayList.toArray(arrayOfObject);
/* 1599 */     return arrayOfObject;
/*      */   }
/*      */   
/*      */   private Object parseArrayItem() {
/* 1603 */     SkipWhite();
/* 1604 */     switch (this.look) { case '"':
/* 1605 */         return parseStringLiteral();
/* 1606 */       case '#': return ErrorConstant.valueOf(parseErrorLiteral());
/*      */       case 'F': case 'T': case 'f':
/*      */       case 't':
/* 1609 */         return parseBooleanLiteral();
/*      */       case '-':
/* 1611 */         Match('-');
/* 1612 */         SkipWhite();
/* 1613 */         return convertArrayNumber(parseNumber(), false); }
/*      */ 
/*      */     
/* 1616 */     return convertArrayNumber(parseNumber(), true);
/*      */   }
/*      */   
/*      */   private Boolean parseBooleanLiteral() {
/* 1620 */     String str = parseUnquotedIdentifier();
/* 1621 */     if ("TRUE".equalsIgnoreCase(str)) {
/* 1622 */       return Boolean.TRUE;
/*      */     }
/* 1624 */     if ("FALSE".equalsIgnoreCase(str)) {
/* 1625 */       return Boolean.FALSE;
/*      */     }
/* 1627 */     throw expected("'TRUE' or 'FALSE'");
/*      */   }
/*      */   
/*      */   private static Double convertArrayNumber(Ptg paramPtg, boolean paramBoolean) {
/*      */     double d;
/* 1632 */     if (paramPtg instanceof IntPtg) {
/* 1633 */       d = ((IntPtg)paramPtg).getValue();
/* 1634 */     } else if (paramPtg instanceof NumberPtg) {
/* 1635 */       d = ((NumberPtg)paramPtg).getValue();
/*      */     } else {
/* 1637 */       throw new RuntimeException("Unexpected ptg (" + paramPtg.getClass().getName() + ")");
/*      */     } 
/* 1639 */     if (!paramBoolean) {
/* 1640 */       d = -d;
/*      */     }
/* 1642 */     return new Double(d);
/*      */   }
/*      */   
/*      */   private Ptg parseNumber() {
/* 1646 */     String str1 = null;
/* 1647 */     String str2 = null;
/* 1648 */     String str3 = GetNum();
/*      */     
/* 1650 */     if (this.look == '.') {
/* 1651 */       GetChar();
/* 1652 */       str1 = GetNum();
/*      */     } 
/*      */     
/* 1655 */     if (this.look == 'E') {
/* 1656 */       GetChar();
/*      */       
/* 1658 */       String str4 = "";
/* 1659 */       if (this.look == '+') {
/* 1660 */         GetChar();
/* 1661 */       } else if (this.look == '-') {
/* 1662 */         GetChar();
/* 1663 */         str4 = "-";
/*      */       } 
/*      */       
/* 1666 */       String str5 = GetNum();
/* 1667 */       if (str5 == null) {
/* 1668 */         throw expected("Integer");
/*      */       }
/* 1670 */       str2 = str4 + str5;
/*      */     } 
/*      */     
/* 1673 */     if (str3 == null && str1 == null) {
/* 1674 */       throw expected("Integer");
/*      */     }
/*      */     
/* 1677 */     return getNumberPtgFromString(str3, str1, str2);
/*      */   }
/*      */   
/*      */   private int parseErrorLiteral() {
/*      */     FormulaError formulaError;
/* 1682 */     Match('#');
/* 1683 */     String str = parseUnquotedIdentifier().toUpperCase(Locale.ROOT);
/* 1684 */     if (str == null) {
/* 1685 */       throw expected("remainder of error constant literal");
/*      */     }
/*      */     
/* 1688 */     switch (str.charAt(0)) {
/*      */       case 'V':
/* 1690 */         formulaError = FormulaError.VALUE;
/* 1691 */         if (str.equals(formulaError.name())) {
/* 1692 */           Match('!');
/* 1693 */           return formulaError.getCode();
/*      */         } 
/* 1695 */         throw expected(formulaError.getString());
/*      */       
/*      */       case 'R':
/* 1698 */         formulaError = FormulaError.REF;
/* 1699 */         if (str.equals(formulaError.name())) {
/* 1700 */           Match('!');
/* 1701 */           return formulaError.getCode();
/*      */         } 
/* 1703 */         throw expected(formulaError.getString());
/*      */       
/*      */       case 'D':
/* 1706 */         formulaError = FormulaError.DIV0;
/* 1707 */         if (str.equals("DIV")) {
/* 1708 */           Match('/');
/* 1709 */           Match('0');
/* 1710 */           Match('!');
/* 1711 */           return formulaError.getCode();
/*      */         } 
/* 1713 */         throw expected(formulaError.getString());
/*      */       
/*      */       case 'N':
/* 1716 */         formulaError = FormulaError.NAME;
/* 1717 */         if (str.equals(formulaError.name())) {
/*      */           
/* 1719 */           Match('?');
/* 1720 */           return formulaError.getCode();
/*      */         } 
/* 1722 */         formulaError = FormulaError.NUM;
/* 1723 */         if (str.equals(formulaError.name())) {
/* 1724 */           Match('!');
/* 1725 */           return formulaError.getCode();
/*      */         } 
/* 1727 */         formulaError = FormulaError.NULL;
/* 1728 */         if (str.equals(formulaError.name())) {
/* 1729 */           Match('!');
/* 1730 */           return formulaError.getCode();
/*      */         } 
/* 1732 */         formulaError = FormulaError.NA;
/* 1733 */         if (str.equals("N")) {
/* 1734 */           Match('/');
/* 1735 */           if (this.look != 'A' && this.look != 'a') {
/* 1736 */             throw expected(formulaError.getString());
/*      */           }
/* 1738 */           Match(this.look);
/*      */           
/* 1740 */           return formulaError.getCode();
/*      */         } 
/* 1742 */         throw expected("#NAME?, #NUM!, #NULL! or #N/A");
/*      */     } 
/*      */     
/* 1745 */     throw expected("#VALUE!, #REF!, #DIV/0!, #NAME?, #NUM!, #NULL! or #N/A");
/*      */   }
/*      */   
/*      */   private String parseUnquotedIdentifier() {
/* 1749 */     if (this.look == '\'') {
/* 1750 */       throw expected("unquoted identifier");
/*      */     }
/* 1752 */     StringBuilder stringBuilder = new StringBuilder();
/* 1753 */     while (Character.isLetterOrDigit(this.look) || this.look == '.') {
/* 1754 */       stringBuilder.append(this.look);
/* 1755 */       GetChar();
/*      */     } 
/* 1757 */     if (stringBuilder.length() < 1) {
/* 1758 */       return null;
/*      */     }
/*      */     
/* 1761 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Ptg getNumberPtgFromString(String paramString1, String paramString2, String paramString3) {
/* 1769 */     StringBuffer stringBuffer = new StringBuffer();
/*      */     
/* 1771 */     if (paramString2 == null) {
/* 1772 */       int i; stringBuffer.append(paramString1);
/*      */       
/* 1774 */       if (paramString3 != null) {
/* 1775 */         stringBuffer.append('E');
/* 1776 */         stringBuffer.append(paramString3);
/*      */       } 
/*      */       
/* 1779 */       String str = stringBuffer.toString();
/*      */       
/*      */       try {
/* 1782 */         i = Integer.parseInt(str);
/* 1783 */       } catch (NumberFormatException numberFormatException) {
/* 1784 */         return (Ptg)new NumberPtg(str);
/*      */       } 
/* 1786 */       if (IntPtg.isInRange(i)) {
/* 1787 */         return (Ptg)new IntPtg(i);
/*      */       }
/* 1789 */       return (Ptg)new NumberPtg(str);
/*      */     } 
/*      */     
/* 1792 */     if (paramString1 != null) {
/* 1793 */       stringBuffer.append(paramString1);
/*      */     }
/*      */     
/* 1796 */     stringBuffer.append('.');
/* 1797 */     stringBuffer.append(paramString2);
/*      */     
/* 1799 */     if (paramString3 != null) {
/* 1800 */       stringBuffer.append('E');
/* 1801 */       stringBuffer.append(paramString3);
/*      */     } 
/*      */     
/* 1804 */     return (Ptg)new NumberPtg(stringBuffer.toString());
/*      */   }
/*      */ 
/*      */   
/*      */   private String parseStringLiteral() {
/* 1809 */     Match('"');
/*      */     
/* 1811 */     StringBuffer stringBuffer = new StringBuffer();
/*      */     while (true) {
/* 1813 */       if (this.look == '"') {
/* 1814 */         GetChar();
/* 1815 */         if (this.look != '"') {
/*      */           break;
/*      */         }
/*      */       } 
/* 1819 */       stringBuffer.append(this.look);
/* 1820 */       GetChar();
/*      */     } 
/* 1822 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private ParseNode Term() {
/* 1827 */     ParseNode parseNode = powerFactor(); while (true) {
/*      */       ValueOperatorPtg valueOperatorPtg;
/* 1829 */       SkipWhite();
/*      */       
/* 1831 */       switch (this.look) {
/*      */         case '*':
/* 1833 */           Match('*');
/* 1834 */           valueOperatorPtg = MultiplyPtg.instance;
/*      */           break;
/*      */         case '/':
/* 1837 */           Match('/');
/* 1838 */           valueOperatorPtg = DividePtg.instance;
/*      */           break;
/*      */         default:
/* 1841 */           return parseNode;
/*      */       } 
/* 1843 */       ParseNode parseNode1 = powerFactor();
/* 1844 */       parseNode = new ParseNode((Ptg)valueOperatorPtg, parseNode, parseNode1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private ParseNode unionExpression() {
/* 1849 */     ParseNode parseNode = intersectionExpression();
/* 1850 */     boolean bool = false; while (true) {
/*      */       ParseNode parseNode1;
/* 1852 */       SkipWhite();
/* 1853 */       switch (this.look) {
/*      */         case ',':
/* 1855 */           GetChar();
/* 1856 */           bool = true;
/* 1857 */           parseNode1 = intersectionExpression();
/* 1858 */           parseNode = new ParseNode((Ptg)UnionPtg.instance, parseNode, parseNode1); continue;
/*      */       }  break;
/*      */     } 
/* 1861 */     if (bool) {
/* 1862 */       return augmentWithMemPtg(parseNode);
/*      */     }
/* 1864 */     return parseNode;
/*      */   }
/*      */ 
/*      */   
/*      */   private ParseNode intersectionExpression() {
/* 1869 */     ParseNode parseNode = comparisonExpression();
/* 1870 */     boolean bool = false;
/*      */     while (true) {
/* 1872 */       SkipWhite();
/* 1873 */       if (this._inIntersection) {
/* 1874 */         int i = this._pointer;
/*      */ 
/*      */         
/*      */         try {
/* 1878 */           ParseNode parseNode1 = comparisonExpression();
/* 1879 */           parseNode = new ParseNode((Ptg)IntersectionPtg.instance, parseNode, parseNode1);
/* 1880 */           bool = true;
/*      */           continue;
/* 1882 */         } catch (FormulaParseException formulaParseException) {
/*      */ 
/*      */           
/* 1885 */           resetPointer(i); break;
/*      */         } 
/*      */       }  break;
/* 1888 */     }  if (bool) {
/* 1889 */       return augmentWithMemPtg(parseNode);
/*      */     }
/* 1891 */     return parseNode;
/*      */   }
/*      */ 
/*      */   
/*      */   private ParseNode comparisonExpression() {
/* 1896 */     ParseNode parseNode = concatExpression(); while (true) {
/*      */       Ptg ptg; ParseNode parseNode1;
/* 1898 */       SkipWhite();
/* 1899 */       switch (this.look) {
/*      */         case '<':
/*      */         case '=':
/*      */         case '>':
/* 1903 */           ptg = getComparisonToken();
/* 1904 */           parseNode1 = concatExpression();
/* 1905 */           parseNode = new ParseNode(ptg, parseNode, parseNode1); continue;
/*      */       }  break;
/*      */     } 
/* 1908 */     return parseNode;
/*      */   }
/*      */ 
/*      */   
/*      */   private Ptg getComparisonToken() {
/* 1913 */     if (this.look == '=') {
/* 1914 */       Match(this.look);
/* 1915 */       return (Ptg)EqualPtg.instance;
/*      */     } 
/* 1917 */     boolean bool = (this.look == '>') ? true : false;
/* 1918 */     Match(this.look);
/* 1919 */     if (bool) {
/* 1920 */       if (this.look == '=') {
/* 1921 */         Match('=');
/* 1922 */         return (Ptg)GreaterEqualPtg.instance;
/*      */       } 
/* 1924 */       return (Ptg)GreaterThanPtg.instance;
/*      */     } 
/* 1926 */     switch (this.look) {
/*      */       case '=':
/* 1928 */         Match('=');
/* 1929 */         return (Ptg)LessEqualPtg.instance;
/*      */       case '>':
/* 1931 */         Match('>');
/* 1932 */         return (Ptg)NotEqualPtg.instance;
/*      */     } 
/* 1934 */     return (Ptg)LessThanPtg.instance;
/*      */   }
/*      */ 
/*      */   
/*      */   private ParseNode concatExpression() {
/* 1939 */     ParseNode parseNode = additiveExpression();
/*      */     while (true) {
/* 1941 */       SkipWhite();
/* 1942 */       if (this.look != '&') {
/*      */         break;
/*      */       }
/* 1945 */       Match('&');
/* 1946 */       ParseNode parseNode1 = additiveExpression();
/* 1947 */       parseNode = new ParseNode((Ptg)ConcatPtg.instance, parseNode, parseNode1);
/*      */     } 
/* 1949 */     return parseNode;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private ParseNode additiveExpression() {
/* 1955 */     ParseNode parseNode = Term(); while (true) {
/*      */       ValueOperatorPtg valueOperatorPtg;
/* 1957 */       SkipWhite();
/*      */       
/* 1959 */       switch (this.look) {
/*      */         case '+':
/* 1961 */           Match('+');
/* 1962 */           valueOperatorPtg = AddPtg.instance;
/*      */           break;
/*      */         case '-':
/* 1965 */           Match('-');
/* 1966 */           valueOperatorPtg = SubtractPtg.instance;
/*      */           break;
/*      */         default:
/* 1969 */           return parseNode;
/*      */       } 
/* 1971 */       ParseNode parseNode1 = Term();
/* 1972 */       parseNode = new ParseNode((Ptg)valueOperatorPtg, parseNode, parseNode1);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void parse() {
/* 1995 */     this._pointer = 0;
/* 1996 */     GetChar();
/* 1997 */     this._rootNode = unionExpression();
/*      */     
/* 1999 */     if (this._pointer <= this._formulaLength) {
/* 2000 */       String str = "Unused input [" + this._formulaString.substring(this._pointer - 1) + "] after attempting to parse the formula [" + this._formulaString + "]";
/*      */       
/* 2002 */       throw new FormulaParseException(str);
/*      */     } 
/*      */   }
/*      */   
/*      */   private Ptg[] getRPNPtg(FormulaType paramFormulaType) {
/* 2007 */     OperandClassTransformer operandClassTransformer = new OperandClassTransformer(paramFormulaType);
/*      */     
/* 2009 */     operandClassTransformer.transformFormula(this._rootNode);
/* 2010 */     return ParseNode.toTokenArray(this._rootNode);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */