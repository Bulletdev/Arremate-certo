/*      */ package org.h2.table;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashSet;
/*      */ import org.h2.command.Parser;
/*      */ import org.h2.command.dml.Select;
/*      */ import org.h2.engine.Session;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.expression.ConditionAndOr;
/*      */ import org.h2.expression.Expression;
/*      */ import org.h2.expression.ExpressionColumn;
/*      */ import org.h2.index.Index;
/*      */ import org.h2.index.IndexCondition;
/*      */ import org.h2.index.IndexCursor;
/*      */ import org.h2.index.IndexLookupBatch;
/*      */ import org.h2.index.ViewIndex;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.result.Row;
/*      */ import org.h2.result.SearchRow;
/*      */ import org.h2.result.SortOrder;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.StatementBuilder;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueLong;
/*      */ import org.h2.value.ValueNull;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TableFilter
/*      */   implements ColumnResolver
/*      */ {
/*      */   private static final int BEFORE_FIRST = 0;
/*      */   private static final int FOUND = 1;
/*      */   private static final int AFTER_LAST = 2;
/*      */   private static final int NULL_ROW = 3;
/*      */   protected boolean joinOuterIndirect;
/*      */   private Session session;
/*      */   private final Table table;
/*      */   private final Select select;
/*      */   private String alias;
/*      */   private Index index;
/*      */   private int[] masks;
/*      */   private int scanCount;
/*      */   private boolean evaluatable;
/*      */   private JoinBatch joinBatch;
/*   67 */   private int joinFilterId = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean used;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final IndexCursor cursor;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   82 */   private final ArrayList<IndexCondition> indexConditions = New.arrayList();
/*      */ 
/*      */ 
/*      */   
/*      */   private Expression filterCondition;
/*      */ 
/*      */ 
/*      */   
/*      */   private Expression joinCondition;
/*      */ 
/*      */ 
/*      */   
/*      */   private SearchRow currentSearchRow;
/*      */ 
/*      */ 
/*      */   
/*      */   private Row current;
/*      */ 
/*      */ 
/*      */   
/*      */   private int state;
/*      */ 
/*      */ 
/*      */   
/*      */   private TableFilter join;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean joinOuter;
/*      */ 
/*      */   
/*      */   private TableFilter nestedJoin;
/*      */ 
/*      */   
/*      */   private ArrayList<Column> naturalJoinColumns;
/*      */ 
/*      */   
/*      */   private boolean foundOne;
/*      */ 
/*      */   
/*      */   private Expression fullCondition;
/*      */ 
/*      */   
/*      */   private final int hashCode;
/*      */ 
/*      */   
/*      */   private final int orderInFrom;
/*      */ 
/*      */ 
/*      */   
/*      */   public TableFilter(Session paramSession, Table paramTable, String paramString, boolean paramBoolean, Select paramSelect, int paramInt) {
/*  133 */     this.session = paramSession;
/*  134 */     this.table = paramTable;
/*  135 */     this.alias = paramString;
/*  136 */     this.select = paramSelect;
/*  137 */     this.cursor = new IndexCursor(this);
/*  138 */     if (!paramBoolean) {
/*  139 */       paramSession.getUser().checkRight(paramTable, 1);
/*      */     }
/*  141 */     this.hashCode = paramSession.nextObjectId();
/*  142 */     this.orderInFrom = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getOrderInFrom() {
/*  152 */     return this.orderInFrom;
/*      */   }
/*      */   
/*      */   public IndexCursor getIndexCursor() {
/*  156 */     return this.cursor;
/*      */   }
/*      */ 
/*      */   
/*      */   public Select getSelect() {
/*  161 */     return this.select;
/*      */   }
/*      */   
/*      */   public Table getTable() {
/*  165 */     return this.table;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lock(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/*  176 */     this.table.lock(paramSession, paramBoolean1, paramBoolean2);
/*  177 */     if (this.join != null) {
/*  178 */       this.join.lock(paramSession, paramBoolean1, paramBoolean2);
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
/*      */   public PlanItem getBestPlanItem(Session paramSession, TableFilter[] paramArrayOfTableFilter, int paramInt, HashSet<Column> paramHashSet) {
/*  194 */     PlanItem planItem1 = null;
/*  195 */     SortOrder sortOrder = null;
/*  196 */     if (this.select != null) {
/*  197 */       sortOrder = this.select.getSortOrder();
/*      */     }
/*  199 */     if (this.indexConditions.size() == 0) {
/*  200 */       planItem1 = new PlanItem();
/*  201 */       planItem1.setIndex(this.table.getScanIndex(paramSession, (int[])null, paramArrayOfTableFilter, paramInt, sortOrder, paramHashSet));
/*      */       
/*  203 */       planItem1.cost = planItem1.getIndex().getCost(paramSession, null, paramArrayOfTableFilter, paramInt, sortOrder, paramHashSet);
/*      */     } 
/*      */     
/*  206 */     int i = (this.table.getColumns()).length;
/*  207 */     int[] arrayOfInt = new int[i];
/*  208 */     for (IndexCondition indexCondition : this.indexConditions) {
/*  209 */       if (indexCondition.isEvaluatable()) {
/*  210 */         if (indexCondition.isAlwaysFalse()) {
/*  211 */           arrayOfInt = null;
/*      */           break;
/*      */         } 
/*  214 */         int j = indexCondition.getColumn().getColumnId();
/*  215 */         if (j >= 0) {
/*  216 */           arrayOfInt[j] = arrayOfInt[j] | indexCondition.getMask(this.indexConditions);
/*      */         }
/*      */       } 
/*      */     } 
/*  220 */     PlanItem planItem2 = this.table.getBestPlanItem(paramSession, arrayOfInt, paramArrayOfTableFilter, paramInt, sortOrder, paramHashSet);
/*  221 */     planItem2.setMasks(arrayOfInt);
/*      */ 
/*      */ 
/*      */     
/*  225 */     planItem2.cost -= planItem2.cost * this.indexConditions.size() / 100.0D / (paramInt + 1);
/*      */     
/*  227 */     if (planItem1 != null && planItem1.cost < planItem2.cost) {
/*  228 */       planItem2 = planItem1;
/*      */     }
/*      */     
/*  231 */     if (this.nestedJoin != null) {
/*  232 */       setEvaluatable(this.nestedJoin);
/*  233 */       planItem2.setNestedJoinPlan(this.nestedJoin.getBestPlanItem(paramSession, paramArrayOfTableFilter, paramInt, paramHashSet));
/*      */ 
/*      */       
/*  236 */       planItem2.cost += planItem2.cost * (planItem2.getNestedJoinPlan()).cost;
/*      */     } 
/*  238 */     if (this.join != null) {
/*  239 */       setEvaluatable(this.join);
/*      */       while (true) {
/*  241 */         paramInt++;
/*  242 */         if (paramArrayOfTableFilter[paramInt] == this.join)
/*  243 */         { planItem2.setJoinPlan(this.join.getBestPlanItem(paramSession, paramArrayOfTableFilter, paramInt, paramHashSet));
/*      */ 
/*      */           
/*  246 */           planItem2.cost += planItem2.cost * (planItem2.getJoinPlan()).cost; break; } 
/*      */       } 
/*  248 */     }  return planItem2;
/*      */   }
/*      */   
/*      */   private void setEvaluatable(TableFilter paramTableFilter) {
/*  252 */     if ((this.session.getDatabase().getSettings()).nestedJoins) {
/*  253 */       setEvaluatable(true);
/*      */       
/*      */       return;
/*      */     } 
/*      */     do {
/*  258 */       Expression expression = paramTableFilter.getJoinCondition();
/*  259 */       if (expression != null) {
/*  260 */         expression.setEvaluatable(this, true);
/*      */       }
/*  262 */       TableFilter tableFilter = paramTableFilter.getNestedJoin();
/*  263 */       if (tableFilter != null) {
/*  264 */         setEvaluatable(tableFilter);
/*      */       }
/*  266 */       paramTableFilter = paramTableFilter.getJoin();
/*  267 */     } while (paramTableFilter != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPlanItem(PlanItem paramPlanItem) {
/*  276 */     if (paramPlanItem == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  281 */     setIndex(paramPlanItem.getIndex());
/*  282 */     this.masks = paramPlanItem.getMasks();
/*  283 */     if (this.nestedJoin != null && 
/*  284 */       paramPlanItem.getNestedJoinPlan() != null) {
/*  285 */       this.nestedJoin.setPlanItem(paramPlanItem.getNestedJoinPlan());
/*      */     }
/*      */     
/*  288 */     if (this.join != null && 
/*  289 */       paramPlanItem.getJoinPlan() != null) {
/*  290 */       this.join.setPlanItem(paramPlanItem.getJoinPlan());
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
/*      */   public void prepare() {
/*  302 */     for (byte b = 0; b < this.indexConditions.size(); b++) {
/*  303 */       IndexCondition indexCondition = this.indexConditions.get(b);
/*  304 */       if (!indexCondition.isAlwaysFalse()) {
/*  305 */         Column column = indexCondition.getColumn();
/*  306 */         if (column.getColumnId() >= 0 && 
/*  307 */           this.index.getColumnIndex(column) < 0) {
/*  308 */           this.indexConditions.remove(b);
/*  309 */           b--;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  314 */     if (this.nestedJoin != null) {
/*  315 */       if (SysProperties.CHECK && this.nestedJoin == this) {
/*  316 */         DbException.throwInternalError("self join");
/*      */       }
/*  318 */       this.nestedJoin.prepare();
/*      */     } 
/*  320 */     if (this.join != null) {
/*  321 */       if (SysProperties.CHECK && this.join == this) {
/*  322 */         DbException.throwInternalError("self join");
/*      */       }
/*  324 */       this.join.prepare();
/*      */     } 
/*  326 */     if (this.filterCondition != null) {
/*  327 */       this.filterCondition = this.filterCondition.optimize(this.session);
/*      */     }
/*  329 */     if (this.joinCondition != null) {
/*  330 */       this.joinCondition = this.joinCondition.optimize(this.session);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void startQuery(Session paramSession) {
/*  340 */     this.session = paramSession;
/*  341 */     this.scanCount = 0;
/*  342 */     if (this.nestedJoin != null) {
/*  343 */       this.nestedJoin.startQuery(paramSession);
/*      */     }
/*  345 */     if (this.join != null) {
/*  346 */       this.join.startQuery(paramSession);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset() {
/*  354 */     if (this.joinBatch != null && this.joinFilterId == 0) {
/*      */       
/*  356 */       this.joinBatch.reset(true);
/*      */       return;
/*      */     } 
/*  359 */     if (this.nestedJoin != null) {
/*  360 */       this.nestedJoin.reset();
/*      */     }
/*  362 */     if (this.join != null) {
/*  363 */       this.join.reset();
/*      */     }
/*  365 */     this.state = 0;
/*  366 */     this.foundOne = false;
/*      */   }
/*      */   
/*      */   private boolean isAlwaysTopTableFilter(int paramInt) {
/*  370 */     if (paramInt != 0) {
/*  371 */       return false;
/*      */     }
/*      */     
/*  374 */     SubQueryInfo subQueryInfo = this.session.getSubQueryInfo();
/*      */     while (true) {
/*  376 */       if (subQueryInfo == null) {
/*  377 */         return true;
/*      */       }
/*  379 */       if (subQueryInfo.getFilter() != 0) {
/*  380 */         return false;
/*      */       }
/*  382 */       subQueryInfo = subQueryInfo.getUpper();
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
/*      */   public JoinBatch prepareJoinBatch(JoinBatch paramJoinBatch, TableFilter[] paramArrayOfTableFilter, int paramInt) {
/*  396 */     assert paramArrayOfTableFilter[paramInt] == this;
/*  397 */     this.joinBatch = null;
/*  398 */     this.joinFilterId = -1;
/*  399 */     if (getTable().isView()) {
/*  400 */       this.session.pushSubQueryInfo(this.masks, paramArrayOfTableFilter, paramInt, this.select.getSortOrder());
/*      */       try {
/*  402 */         ((ViewIndex)this.index).getQuery().prepareJoinBatch();
/*      */       } finally {
/*  404 */         this.session.popSubQueryInfo();
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  416 */     IndexLookupBatch indexLookupBatch = null;
/*  417 */     if (paramJoinBatch == null && this.select != null && !isAlwaysTopTableFilter(paramInt)) {
/*  418 */       indexLookupBatch = this.index.createLookupBatch(paramArrayOfTableFilter, paramInt);
/*  419 */       if (indexLookupBatch != null) {
/*  420 */         paramJoinBatch = new JoinBatch(paramInt + 1, this.join);
/*      */       }
/*      */     } 
/*  423 */     if (paramJoinBatch != null) {
/*  424 */       if (this.nestedJoin != null) {
/*  425 */         throw DbException.throwInternalError();
/*      */       }
/*  427 */       this.joinBatch = paramJoinBatch;
/*  428 */       this.joinFilterId = paramInt;
/*  429 */       if (indexLookupBatch == null && !isAlwaysTopTableFilter(paramInt)) {
/*      */ 
/*      */ 
/*      */         
/*  433 */         indexLookupBatch = this.index.createLookupBatch(paramArrayOfTableFilter, paramInt);
/*  434 */         if (indexLookupBatch == null)
/*      */         {
/*      */           
/*  437 */           indexLookupBatch = JoinBatch.createFakeIndexLookupBatch(this);
/*      */         }
/*      */       } 
/*  440 */       paramJoinBatch.register(this, indexLookupBatch);
/*      */     } 
/*  442 */     return paramJoinBatch;
/*      */   }
/*      */   
/*      */   public int getJoinFilterId() {
/*  446 */     return this.joinFilterId;
/*      */   }
/*      */   
/*      */   public JoinBatch getJoinBatch() {
/*  450 */     return this.joinBatch;
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
/*      */   public boolean next() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield joinBatch : Lorg/h2/table/JoinBatch;
/*      */     //   4: ifnull -> 15
/*      */     //   7: aload_0
/*      */     //   8: getfield joinBatch : Lorg/h2/table/JoinBatch;
/*      */     //   11: invokevirtual next : ()Z
/*      */     //   14: ireturn
/*      */     //   15: aload_0
/*      */     //   16: getfield state : I
/*      */     //   19: iconst_2
/*      */     //   20: if_icmpne -> 25
/*      */     //   23: iconst_0
/*      */     //   24: ireturn
/*      */     //   25: aload_0
/*      */     //   26: getfield state : I
/*      */     //   29: ifne -> 88
/*      */     //   32: aload_0
/*      */     //   33: getfield cursor : Lorg/h2/index/IndexCursor;
/*      */     //   36: aload_0
/*      */     //   37: getfield session : Lorg/h2/engine/Session;
/*      */     //   40: aload_0
/*      */     //   41: getfield indexConditions : Ljava/util/ArrayList;
/*      */     //   44: invokevirtual find : (Lorg/h2/engine/Session;Ljava/util/ArrayList;)V
/*      */     //   47: aload_0
/*      */     //   48: getfield cursor : Lorg/h2/index/IndexCursor;
/*      */     //   51: invokevirtual isAlwaysFalse : ()Z
/*      */     //   54: ifne -> 107
/*      */     //   57: aload_0
/*      */     //   58: getfield nestedJoin : Lorg/h2/table/TableFilter;
/*      */     //   61: ifnull -> 71
/*      */     //   64: aload_0
/*      */     //   65: getfield nestedJoin : Lorg/h2/table/TableFilter;
/*      */     //   68: invokevirtual reset : ()V
/*      */     //   71: aload_0
/*      */     //   72: getfield join : Lorg/h2/table/TableFilter;
/*      */     //   75: ifnull -> 107
/*      */     //   78: aload_0
/*      */     //   79: getfield join : Lorg/h2/table/TableFilter;
/*      */     //   82: invokevirtual reset : ()V
/*      */     //   85: goto -> 107
/*      */     //   88: aload_0
/*      */     //   89: getfield join : Lorg/h2/table/TableFilter;
/*      */     //   92: ifnull -> 107
/*      */     //   95: aload_0
/*      */     //   96: getfield join : Lorg/h2/table/TableFilter;
/*      */     //   99: invokevirtual next : ()Z
/*      */     //   102: ifeq -> 107
/*      */     //   105: iconst_1
/*      */     //   106: ireturn
/*      */     //   107: aload_0
/*      */     //   108: getfield state : I
/*      */     //   111: iconst_3
/*      */     //   112: if_icmpne -> 118
/*      */     //   115: goto -> 373
/*      */     //   118: aload_0
/*      */     //   119: getfield cursor : Lorg/h2/index/IndexCursor;
/*      */     //   122: invokevirtual isAlwaysFalse : ()Z
/*      */     //   125: ifeq -> 136
/*      */     //   128: aload_0
/*      */     //   129: iconst_2
/*      */     //   130: putfield state : I
/*      */     //   133: goto -> 219
/*      */     //   136: aload_0
/*      */     //   137: getfield nestedJoin : Lorg/h2/table/TableFilter;
/*      */     //   140: ifnull -> 158
/*      */     //   143: aload_0
/*      */     //   144: getfield state : I
/*      */     //   147: ifne -> 219
/*      */     //   150: aload_0
/*      */     //   151: iconst_1
/*      */     //   152: putfield state : I
/*      */     //   155: goto -> 219
/*      */     //   158: aload_0
/*      */     //   159: dup
/*      */     //   160: getfield scanCount : I
/*      */     //   163: iconst_1
/*      */     //   164: iadd
/*      */     //   165: dup_x1
/*      */     //   166: putfield scanCount : I
/*      */     //   169: sipush #4095
/*      */     //   172: iand
/*      */     //   173: ifne -> 180
/*      */     //   176: aload_0
/*      */     //   177: invokespecial checkTimeout : ()V
/*      */     //   180: aload_0
/*      */     //   181: getfield cursor : Lorg/h2/index/IndexCursor;
/*      */     //   184: invokevirtual next : ()Z
/*      */     //   187: ifeq -> 214
/*      */     //   190: aload_0
/*      */     //   191: aload_0
/*      */     //   192: getfield cursor : Lorg/h2/index/IndexCursor;
/*      */     //   195: invokevirtual getSearchRow : ()Lorg/h2/result/SearchRow;
/*      */     //   198: putfield currentSearchRow : Lorg/h2/result/SearchRow;
/*      */     //   201: aload_0
/*      */     //   202: aconst_null
/*      */     //   203: putfield current : Lorg/h2/result/Row;
/*      */     //   206: aload_0
/*      */     //   207: iconst_1
/*      */     //   208: putfield state : I
/*      */     //   211: goto -> 219
/*      */     //   214: aload_0
/*      */     //   215: iconst_2
/*      */     //   216: putfield state : I
/*      */     //   219: aload_0
/*      */     //   220: getfield nestedJoin : Lorg/h2/table/TableFilter;
/*      */     //   223: ifnull -> 263
/*      */     //   226: aload_0
/*      */     //   227: getfield state : I
/*      */     //   230: iconst_1
/*      */     //   231: if_icmpne -> 263
/*      */     //   234: aload_0
/*      */     //   235: getfield nestedJoin : Lorg/h2/table/TableFilter;
/*      */     //   238: invokevirtual next : ()Z
/*      */     //   241: ifne -> 263
/*      */     //   244: aload_0
/*      */     //   245: iconst_2
/*      */     //   246: putfield state : I
/*      */     //   249: aload_0
/*      */     //   250: getfield joinOuter : Z
/*      */     //   253: ifeq -> 107
/*      */     //   256: aload_0
/*      */     //   257: getfield foundOne : Z
/*      */     //   260: ifne -> 107
/*      */     //   263: aload_0
/*      */     //   264: getfield state : I
/*      */     //   267: iconst_2
/*      */     //   268: if_icmpne -> 289
/*      */     //   271: aload_0
/*      */     //   272: getfield joinOuter : Z
/*      */     //   275: ifeq -> 373
/*      */     //   278: aload_0
/*      */     //   279: getfield foundOne : Z
/*      */     //   282: ifne -> 373
/*      */     //   285: aload_0
/*      */     //   286: invokevirtual setNullRow : ()V
/*      */     //   289: aload_0
/*      */     //   290: aload_0
/*      */     //   291: getfield filterCondition : Lorg/h2/expression/Expression;
/*      */     //   294: invokevirtual isOk : (Lorg/h2/expression/Expression;)Z
/*      */     //   297: ifne -> 303
/*      */     //   300: goto -> 107
/*      */     //   303: aload_0
/*      */     //   304: aload_0
/*      */     //   305: getfield joinCondition : Lorg/h2/expression/Expression;
/*      */     //   308: invokevirtual isOk : (Lorg/h2/expression/Expression;)Z
/*      */     //   311: istore_1
/*      */     //   312: aload_0
/*      */     //   313: getfield state : I
/*      */     //   316: iconst_1
/*      */     //   317: if_icmpne -> 329
/*      */     //   320: iload_1
/*      */     //   321: ifeq -> 107
/*      */     //   324: aload_0
/*      */     //   325: iconst_1
/*      */     //   326: putfield foundOne : Z
/*      */     //   329: aload_0
/*      */     //   330: getfield join : Lorg/h2/table/TableFilter;
/*      */     //   333: ifnull -> 356
/*      */     //   336: aload_0
/*      */     //   337: getfield join : Lorg/h2/table/TableFilter;
/*      */     //   340: invokevirtual reset : ()V
/*      */     //   343: aload_0
/*      */     //   344: getfield join : Lorg/h2/table/TableFilter;
/*      */     //   347: invokevirtual next : ()Z
/*      */     //   350: ifne -> 356
/*      */     //   353: goto -> 107
/*      */     //   356: aload_0
/*      */     //   357: getfield state : I
/*      */     //   360: iconst_3
/*      */     //   361: if_icmpeq -> 368
/*      */     //   364: iload_1
/*      */     //   365: ifeq -> 370
/*      */     //   368: iconst_1
/*      */     //   369: ireturn
/*      */     //   370: goto -> 107
/*      */     //   373: aload_0
/*      */     //   374: iconst_2
/*      */     //   375: putfield state : I
/*      */     //   378: iconst_0
/*      */     //   379: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #459	-> 0
/*      */     //   #462	-> 7
/*      */     //   #464	-> 15
/*      */     //   #465	-> 23
/*      */     //   #466	-> 25
/*      */     //   #467	-> 32
/*      */     //   #468	-> 47
/*      */     //   #469	-> 57
/*      */     //   #470	-> 64
/*      */     //   #472	-> 71
/*      */     //   #473	-> 78
/*      */     //   #479	-> 88
/*      */     //   #480	-> 105
/*      */     //   #485	-> 107
/*      */     //   #486	-> 115
/*      */     //   #488	-> 118
/*      */     //   #489	-> 128
/*      */     //   #490	-> 136
/*      */     //   #491	-> 143
/*      */     //   #492	-> 150
/*      */     //   #495	-> 158
/*      */     //   #496	-> 176
/*      */     //   #498	-> 180
/*      */     //   #499	-> 190
/*      */     //   #500	-> 201
/*      */     //   #501	-> 206
/*      */     //   #503	-> 214
/*      */     //   #506	-> 219
/*      */     //   #507	-> 234
/*      */     //   #508	-> 244
/*      */     //   #509	-> 249
/*      */     //   #517	-> 263
/*      */     //   #518	-> 271
/*      */     //   #519	-> 285
/*      */     //   #524	-> 289
/*      */     //   #525	-> 300
/*      */     //   #527	-> 303
/*      */     //   #528	-> 312
/*      */     //   #529	-> 320
/*      */     //   #530	-> 324
/*      */     //   #535	-> 329
/*      */     //   #536	-> 336
/*      */     //   #537	-> 343
/*      */     //   #538	-> 353
/*      */     //   #542	-> 356
/*      */     //   #543	-> 368
/*      */     //   #545	-> 370
/*      */     //   #546	-> 373
/*      */     //   #547	-> 378
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
/*      */   protected void setNullRow() {
/*  554 */     this.state = 3;
/*  555 */     this.current = this.table.getNullRow();
/*  556 */     this.currentSearchRow = (SearchRow)this.current;
/*  557 */     if (this.nestedJoin != null) {
/*  558 */       this.nestedJoin.visit(new TableFilterVisitor()
/*      */           {
/*      */             public void accept(TableFilter param1TableFilter) {
/*  561 */               param1TableFilter.setNullRow();
/*      */             }
/*      */           });
/*      */     }
/*      */   }
/*      */   
/*      */   private void checkTimeout() {
/*  568 */     this.session.checkCanceled();
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
/*      */   boolean isOk(Expression paramExpression) {
/*  581 */     if (paramExpression == null) {
/*  582 */       return true;
/*      */     }
/*  584 */     return Boolean.TRUE.equals(paramExpression.getBooleanValue(this.session));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Row get() {
/*  593 */     if (this.current == null && this.currentSearchRow != null) {
/*  594 */       this.current = this.cursor.get();
/*      */     }
/*  596 */     return this.current;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set(Row paramRow) {
/*  607 */     this.current = paramRow;
/*  608 */     this.currentSearchRow = (SearchRow)paramRow;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getTableAlias() {
/*  619 */     if (this.alias != null) {
/*  620 */       return this.alias;
/*      */     }
/*  622 */     return this.table.getName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addIndexCondition(IndexCondition paramIndexCondition) {
/*  631 */     this.indexConditions.add(paramIndexCondition);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addFilterCondition(Expression paramExpression, boolean paramBoolean) {
/*  641 */     if (paramBoolean) {
/*  642 */       if (this.joinCondition == null) {
/*  643 */         this.joinCondition = paramExpression;
/*      */       } else {
/*  645 */         this.joinCondition = (Expression)new ConditionAndOr(0, this.joinCondition, paramExpression);
/*      */       }
/*      */     
/*      */     }
/*  649 */     else if (this.filterCondition == null) {
/*  650 */       this.filterCondition = paramExpression;
/*      */     } else {
/*  652 */       this.filterCondition = (Expression)new ConditionAndOr(0, this.filterCondition, paramExpression);
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
/*      */   public void addJoin(TableFilter paramTableFilter, boolean paramBoolean1, boolean paramBoolean2, final Expression on) {
/*  668 */     if (on != null) {
/*  669 */       on.mapColumns(this, 0);
/*  670 */       if ((this.session.getDatabase().getSettings()).nestedJoins) {
/*  671 */         visit(new TableFilterVisitor()
/*      */             {
/*      */               public void accept(TableFilter param1TableFilter) {
/*  674 */                 on.mapColumns(param1TableFilter, 0);
/*      */               }
/*      */             });
/*  677 */         paramTableFilter.visit(new TableFilterVisitor()
/*      */             {
/*      */               public void accept(TableFilter param1TableFilter) {
/*  680 */                 on.mapColumns(param1TableFilter, 0);
/*      */               }
/*      */             });
/*      */       } 
/*      */     } 
/*  685 */     if (paramBoolean2 && (this.session.getDatabase().getSettings()).nestedJoins) {
/*  686 */       if (this.nestedJoin != null) {
/*  687 */         throw DbException.throwInternalError();
/*      */       }
/*  689 */       this.nestedJoin = paramTableFilter;
/*  690 */       paramTableFilter.joinOuter = paramBoolean1;
/*  691 */       if (paramBoolean1) {
/*  692 */         visit(new TableFilterVisitor()
/*      */             {
/*      */               public void accept(TableFilter param1TableFilter) {
/*  695 */                 param1TableFilter.joinOuterIndirect = true;
/*      */               }
/*      */             });
/*      */       }
/*  699 */       if (on != null) {
/*  700 */         paramTableFilter.mapAndAddFilter(on);
/*      */       }
/*      */     }
/*  703 */     else if (this.join == null) {
/*  704 */       this.join = paramTableFilter;
/*  705 */       paramTableFilter.joinOuter = paramBoolean1;
/*  706 */       if ((this.session.getDatabase().getSettings()).nestedJoins) {
/*  707 */         if (paramBoolean1) {
/*  708 */           paramTableFilter.visit(new TableFilterVisitor()
/*      */               {
/*      */                 public void accept(TableFilter param1TableFilter) {
/*  711 */                   param1TableFilter.joinOuterIndirect = true;
/*      */                 }
/*      */               });
/*      */         }
/*      */       }
/*  716 */       else if (paramBoolean1) {
/*      */ 
/*      */         
/*  719 */         TableFilter tableFilter = paramTableFilter.join;
/*  720 */         while (tableFilter != null) {
/*  721 */           tableFilter.joinOuter = true;
/*  722 */           tableFilter = tableFilter.join;
/*      */         } 
/*      */       } 
/*      */       
/*  726 */       if (on != null) {
/*  727 */         paramTableFilter.mapAndAddFilter(on);
/*      */       }
/*      */     } else {
/*  730 */       this.join.addJoin(paramTableFilter, paramBoolean1, paramBoolean2, on);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void mapAndAddFilter(Expression paramExpression) {
/*  741 */     paramExpression.mapColumns(this, 0);
/*  742 */     addFilterCondition(paramExpression, true);
/*  743 */     paramExpression.createIndexConditions(this.session, this);
/*  744 */     if (this.nestedJoin != null) {
/*  745 */       paramExpression.mapColumns(this.nestedJoin, 0);
/*  746 */       paramExpression.createIndexConditions(this.session, this.nestedJoin);
/*      */     } 
/*  748 */     if (this.join != null) {
/*  749 */       this.join.mapAndAddFilter(paramExpression);
/*      */     }
/*      */   }
/*      */   
/*      */   public TableFilter getJoin() {
/*  754 */     return this.join;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isJoinOuter() {
/*  763 */     return this.joinOuter;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isJoinOuterIndirect() {
/*  773 */     return this.joinOuterIndirect;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPlanSQL(boolean paramBoolean) {
/*  783 */     StringBuilder stringBuilder = new StringBuilder();
/*  784 */     if (paramBoolean) {
/*  785 */       if (this.joinOuter) {
/*  786 */         stringBuilder.append("LEFT OUTER JOIN ");
/*      */       } else {
/*  788 */         stringBuilder.append("INNER JOIN ");
/*      */       } 
/*      */     }
/*  791 */     if (this.nestedJoin != null) {
/*  792 */       StringBuffer stringBuffer = new StringBuffer();
/*  793 */       TableFilter tableFilter = this.nestedJoin;
/*      */       while (true) {
/*  795 */         stringBuffer.append(tableFilter.getPlanSQL((tableFilter != this.nestedJoin)));
/*  796 */         stringBuffer.append('\n');
/*  797 */         tableFilter = tableFilter.getJoin();
/*  798 */         if (tableFilter == null)
/*  799 */         { String str = stringBuffer.toString();
/*  800 */           boolean bool = !str.startsWith("(") ? true : false;
/*  801 */           if (bool) {
/*  802 */             stringBuilder.append("(\n");
/*      */           }
/*  804 */           stringBuilder.append(StringUtils.indent(str, 4, false));
/*  805 */           if (bool) {
/*  806 */             stringBuilder.append(')');
/*      */           }
/*  808 */           if (paramBoolean) {
/*  809 */             stringBuilder.append(" ON ");
/*  810 */             if (this.joinCondition == null) {
/*      */ 
/*      */               
/*  813 */               stringBuilder.append("1=1");
/*      */             } else {
/*  815 */               stringBuilder.append(StringUtils.unEnclose(this.joinCondition.getSQL()));
/*      */             } 
/*      */           } 
/*  818 */           return stringBuilder.toString(); } 
/*      */       } 
/*  820 */     }  if (this.table.isView() && ((TableView)this.table).isRecursive()) {
/*  821 */       stringBuilder.append(this.table.getName());
/*      */     } else {
/*  823 */       stringBuilder.append(this.table.getSQL());
/*      */     } 
/*  825 */     if (this.table.isView() && ((TableView)this.table).isInvalid()) {
/*  826 */       throw DbException.get(90109, new String[] { this.table.getName(), "not compiled" });
/*      */     }
/*  828 */     if (this.alias != null) {
/*  829 */       stringBuilder.append(' ').append(Parser.quoteIdentifier(this.alias));
/*      */     }
/*  831 */     if (this.index != null) {
/*  832 */       stringBuilder.append('\n');
/*  833 */       StatementBuilder statementBuilder = new StatementBuilder();
/*  834 */       if (this.joinBatch != null) {
/*  835 */         IndexLookupBatch indexLookupBatch = this.joinBatch.getLookupBatch(this.joinFilterId);
/*  836 */         if (indexLookupBatch == null) {
/*  837 */           if (this.joinFilterId != 0) {
/*  838 */             throw DbException.throwInternalError();
/*      */           }
/*      */         } else {
/*  841 */           statementBuilder.append("batched:");
/*  842 */           String str1 = indexLookupBatch.getPlanSQL();
/*  843 */           statementBuilder.append(str1);
/*  844 */           statementBuilder.append(" ");
/*      */         } 
/*      */       } 
/*  847 */       statementBuilder.append(this.index.getPlanSQL());
/*  848 */       if (this.indexConditions.size() > 0) {
/*  849 */         statementBuilder.append(": ");
/*  850 */         for (IndexCondition indexCondition : this.indexConditions) {
/*  851 */           statementBuilder.appendExceptFirst("\n    AND ");
/*  852 */           statementBuilder.append(indexCondition.getSQL());
/*      */         } 
/*      */       } 
/*  855 */       String str = StringUtils.quoteRemarkSQL(statementBuilder.toString());
/*  856 */       if (str.indexOf('\n') >= 0) {
/*  857 */         str = str + "\n";
/*      */       }
/*  859 */       stringBuilder.append(StringUtils.indent("/* " + str + " */", 4, false));
/*      */     } 
/*  861 */     if (paramBoolean) {
/*  862 */       stringBuilder.append("\n    ON ");
/*  863 */       if (this.joinCondition == null) {
/*      */ 
/*      */         
/*  866 */         stringBuilder.append("1=1");
/*      */       } else {
/*  868 */         stringBuilder.append(StringUtils.unEnclose(this.joinCondition.getSQL()));
/*      */       } 
/*      */     } 
/*  871 */     if (this.filterCondition != null) {
/*  872 */       stringBuilder.append('\n');
/*  873 */       String str = StringUtils.unEnclose(this.filterCondition.getSQL());
/*  874 */       str = "/* WHERE " + StringUtils.quoteRemarkSQL(str) + "\n*/";
/*  875 */       stringBuilder.append(StringUtils.indent(str, 4, false));
/*      */     } 
/*  877 */     if (this.scanCount > 0) {
/*  878 */       stringBuilder.append("\n    /* scanCount: ").append(this.scanCount).append(" */");
/*      */     }
/*  880 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void removeUnusableIndexConditions() {
/*  888 */     for (byte b = 0; b < this.indexConditions.size(); b++) {
/*  889 */       IndexCondition indexCondition = this.indexConditions.get(b);
/*  890 */       if (!indexCondition.isEvaluatable()) {
/*  891 */         this.indexConditions.remove(b--);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public int[] getMasks() {
/*  897 */     return this.masks;
/*      */   }
/*      */   
/*      */   public ArrayList<IndexCondition> getIndexConditions() {
/*  901 */     return this.indexConditions;
/*      */   }
/*      */   
/*      */   public Index getIndex() {
/*  905 */     return this.index;
/*      */   }
/*      */   
/*      */   public void setIndex(Index paramIndex) {
/*  909 */     this.index = paramIndex;
/*  910 */     this.cursor.setIndex(paramIndex);
/*      */   }
/*      */   
/*      */   public void setUsed(boolean paramBoolean) {
/*  914 */     this.used = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isUsed() {
/*  918 */     return this.used;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setSession(Session paramSession) {
/*  927 */     this.session = paramSession;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeJoin() {
/*  934 */     this.join = null;
/*      */   }
/*      */   
/*      */   public Expression getJoinCondition() {
/*  938 */     return this.joinCondition;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeJoinCondition() {
/*  945 */     this.joinCondition = null;
/*      */   }
/*      */   
/*      */   public Expression getFilterCondition() {
/*  949 */     return this.filterCondition;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeFilterCondition() {
/*  956 */     this.filterCondition = null;
/*      */   }
/*      */   
/*      */   public void setFullCondition(Expression paramExpression) {
/*  960 */     this.fullCondition = paramExpression;
/*  961 */     if (this.join != null) {
/*  962 */       this.join.setFullCondition(paramExpression);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void optimizeFullCondition(boolean paramBoolean) {
/*  973 */     if (this.fullCondition != null) {
/*  974 */       this.fullCondition.addFilterConditions(this, (paramBoolean || this.joinOuter));
/*  975 */       if (this.nestedJoin != null) {
/*  976 */         this.nestedJoin.optimizeFullCondition((paramBoolean || this.joinOuter));
/*      */       }
/*  978 */       if (this.join != null) {
/*  979 */         this.join.optimizeFullCondition((paramBoolean || this.joinOuter));
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
/*      */ 
/*      */   
/*      */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/*  993 */     paramTableFilter.setEvaluatable(paramBoolean);
/*  994 */     if (this.filterCondition != null) {
/*  995 */       this.filterCondition.setEvaluatable(paramTableFilter, paramBoolean);
/*      */     }
/*  997 */     if (this.joinCondition != null) {
/*  998 */       this.joinCondition.setEvaluatable(paramTableFilter, paramBoolean);
/*      */     }
/* 1000 */     if (this.nestedJoin != null)
/*      */     {
/*      */       
/* 1003 */       if (this == paramTableFilter) {
/* 1004 */         this.nestedJoin.setEvaluatable(this.nestedJoin, paramBoolean);
/*      */       }
/*      */     }
/* 1007 */     if (this.join != null) {
/* 1008 */       this.join.setEvaluatable(paramTableFilter, paramBoolean);
/*      */     }
/*      */   }
/*      */   
/*      */   public void setEvaluatable(boolean paramBoolean) {
/* 1013 */     this.evaluatable = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getSchemaName() {
/* 1018 */     return this.table.getSchema().getName();
/*      */   }
/*      */ 
/*      */   
/*      */   public Column[] getColumns() {
/* 1023 */     return this.table.getColumns();
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
/*      */   public Column[] getSystemColumns() {
/* 1035 */     if (!(this.session.getDatabase().getMode()).systemColumns) {
/* 1036 */       return null;
/*      */     }
/* 1038 */     Column[] arrayOfColumn = new Column[3];
/* 1039 */     arrayOfColumn[0] = new Column("oid", 4);
/* 1040 */     arrayOfColumn[0].setTable(this.table, 0);
/* 1041 */     arrayOfColumn[1] = new Column("ctid", 13);
/* 1042 */     arrayOfColumn[1].setTable(this.table, 0);
/* 1043 */     arrayOfColumn[2] = new Column("CTID", 13);
/* 1044 */     arrayOfColumn[2].setTable(this.table, 0);
/* 1045 */     return arrayOfColumn;
/*      */   }
/*      */ 
/*      */   
/*      */   public Column getRowIdColumn() {
/* 1050 */     if ((this.session.getDatabase().getSettings()).rowId) {
/* 1051 */       return this.table.getRowIdColumn();
/*      */     }
/* 1053 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public Value getValue(Column paramColumn) {
/* 1058 */     if (this.joinBatch != null) {
/* 1059 */       return this.joinBatch.getValue(this.joinFilterId, paramColumn);
/*      */     }
/* 1061 */     if (this.currentSearchRow == null) {
/* 1062 */       return null;
/*      */     }
/* 1064 */     int i = paramColumn.getColumnId();
/* 1065 */     if (i == -1) {
/* 1066 */       return (Value)ValueLong.get(this.currentSearchRow.getKey());
/*      */     }
/* 1068 */     if (this.current == null) {
/* 1069 */       Value value = this.currentSearchRow.getValue(i);
/* 1070 */       if (value != null) {
/* 1071 */         return value;
/*      */       }
/* 1073 */       this.current = this.cursor.get();
/* 1074 */       if (this.current == null) {
/* 1075 */         return (Value)ValueNull.INSTANCE;
/*      */       }
/*      */     } 
/* 1078 */     return this.current.getValue(i);
/*      */   }
/*      */ 
/*      */   
/*      */   public TableFilter getTableFilter() {
/* 1083 */     return this;
/*      */   }
/*      */   
/*      */   public void setAlias(String paramString) {
/* 1087 */     this.alias = paramString;
/*      */   }
/*      */ 
/*      */   
/*      */   public Expression optimize(ExpressionColumn paramExpressionColumn, Column paramColumn) {
/* 1092 */     return (Expression)paramExpressionColumn;
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1097 */     return (this.alias != null) ? this.alias : this.table.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addNaturalJoinColumn(Column paramColumn) {
/* 1106 */     if (this.naturalJoinColumns == null) {
/* 1107 */       this.naturalJoinColumns = New.arrayList();
/*      */     }
/* 1109 */     this.naturalJoinColumns.add(paramColumn);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNaturalJoinColumn(Column paramColumn) {
/* 1119 */     return (this.naturalJoinColumns != null && this.naturalJoinColumns.contains(paramColumn));
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1124 */     return this.hashCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasInComparisons() {
/* 1133 */     for (IndexCondition indexCondition : this.indexConditions) {
/* 1134 */       int i = indexCondition.getCompareType();
/* 1135 */       if (i == 10 || i == 9) {
/* 1136 */         return true;
/*      */       }
/*      */     } 
/* 1139 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockRowAdd(ArrayList<Row> paramArrayList) {
/* 1148 */     if (this.state == 1) {
/* 1149 */       paramArrayList.add(get());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockRows(ArrayList<Row> paramArrayList) {
/* 1159 */     for (Row row1 : paramArrayList) {
/* 1160 */       Row row2 = row1.getCopy();
/* 1161 */       this.table.removeRow(this.session, row1);
/* 1162 */       this.session.log(this.table, (short)1, row1);
/* 1163 */       this.table.addRow(this.session, row2);
/* 1164 */       this.session.log(this.table, (short)0, row2);
/*      */     } 
/*      */   }
/*      */   
/*      */   public TableFilter getNestedJoin() {
/* 1169 */     return this.nestedJoin;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void visit(TableFilterVisitor paramTableFilterVisitor) {
/* 1178 */     TableFilter tableFilter = this;
/*      */     do {
/* 1180 */       paramTableFilterVisitor.accept(tableFilter);
/* 1181 */       TableFilter tableFilter1 = tableFilter.nestedJoin;
/* 1182 */       if (tableFilter1 != null) {
/* 1183 */         tableFilter1.visit(paramTableFilterVisitor);
/*      */       }
/* 1185 */       tableFilter = tableFilter.join;
/* 1186 */     } while (tableFilter != null);
/*      */   }
/*      */   
/*      */   public boolean isEvaluatable() {
/* 1190 */     return this.evaluatable;
/*      */   }
/*      */   
/*      */   public Session getSession() {
/* 1194 */     return this.session;
/*      */   }
/*      */   
/*      */   public static interface TableFilterVisitor {
/*      */     void accept(TableFilter param1TableFilter);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\TableFilter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */