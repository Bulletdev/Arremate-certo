/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import org.h2.api.Aggregate;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.command.dml.Select;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SessionInterface;
/*     */ import org.h2.engine.UserAggregate;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JavaAggregate
/*     */   extends Expression
/*     */ {
/*     */   private final UserAggregate userAggregate;
/*     */   private final Select select;
/*     */   private final Expression[] args;
/*     */   private int[] argTypes;
/*     */   private int dataType;
/*     */   private Connection userConnection;
/*     */   private int lastGroupRowId;
/*     */   
/*     */   public JavaAggregate(UserAggregate paramUserAggregate, Expression[] paramArrayOfExpression, Select paramSelect) {
/*  40 */     this.userAggregate = paramUserAggregate;
/*  41 */     this.args = paramArrayOfExpression;
/*  42 */     this.select = paramSelect;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/*  47 */     int i = 5;
/*  48 */     for (Expression expression : this.args) {
/*  49 */       i += expression.getCost();
/*     */     }
/*  51 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  56 */     return 2147483647L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  61 */     return Integer.MAX_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  66 */     return (DataType.getDataType(this.dataType)).defaultScale;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  71 */     StatementBuilder statementBuilder = new StatementBuilder();
/*  72 */     statementBuilder.append(Parser.quoteIdentifier(this.userAggregate.getName())).append('(');
/*  73 */     for (Expression expression : this.args) {
/*  74 */       statementBuilder.appendExceptFirst(", ");
/*  75 */       statementBuilder.append(expression.getSQL());
/*     */     } 
/*  77 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  82 */     return this.dataType;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/*  87 */     switch (paramExpressionVisitor.getType()) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/*     */       case 2:
/*  93 */         return false;
/*     */       case 7:
/*  95 */         paramExpressionVisitor.addDependency((DbObject)this.userAggregate);
/*     */         break;
/*     */     } 
/*     */     
/*  99 */     for (Expression expression : this.args) {
/* 100 */       if (expression != null && !expression.isEverything(paramExpressionVisitor)) {
/* 101 */         return false;
/*     */       }
/*     */     } 
/* 104 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 109 */     for (Expression expression : this.args) {
/* 110 */       expression.mapColumns(paramColumnResolver, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/* 116 */     this.userConnection = (Connection)paramSession.createConnection(false);
/* 117 */     int i = this.args.length;
/* 118 */     this.argTypes = new int[i];
/* 119 */     for (byte b = 0; b < i; b++) {
/* 120 */       Expression expression = this.args[b];
/* 121 */       this.args[b] = expression.optimize(paramSession);
/* 122 */       int j = expression.getType();
/* 123 */       this.argTypes[b] = j;
/*     */     } 
/*     */     try {
/* 126 */       Aggregate aggregate = getInstance();
/* 127 */       this.dataType = aggregate.getInternalType(this.argTypes);
/* 128 */     } catch (SQLException sQLException) {
/* 129 */       throw DbException.convert(sQLException);
/*     */     } 
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 136 */     for (Expression expression : this.args) {
/* 137 */       expression.setEvaluatable(paramTableFilter, paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   private Aggregate getInstance() throws SQLException {
/* 142 */     Aggregate aggregate = this.userAggregate.getInstance();
/* 143 */     aggregate.init(this.userConnection);
/* 144 */     return aggregate;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/* 149 */     HashMap hashMap = this.select.getCurrentGroup();
/* 150 */     if (hashMap == null) {
/* 151 */       throw DbException.get(90054, getSQL());
/*     */     }
/*     */     try {
/* 154 */       Aggregate aggregate = (Aggregate)hashMap.get(this);
/* 155 */       if (aggregate == null) {
/* 156 */         aggregate = getInstance();
/*     */       }
/* 158 */       Object object = aggregate.getResult();
/* 159 */       if (object == null) {
/* 160 */         return (Value)ValueNull.INSTANCE;
/*     */       }
/* 162 */       return DataType.convertToValue((SessionInterface)paramSession, object, this.dataType);
/* 163 */     } catch (SQLException sQLException) {
/* 164 */       throw DbException.convert(sQLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 170 */     HashMap<JavaAggregate, Aggregate> hashMap = this.select.getCurrentGroup();
/* 171 */     if (hashMap == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 176 */     int i = this.select.getCurrentGroupRowId();
/* 177 */     if (this.lastGroupRowId == i) {
/*     */       return;
/*     */     }
/*     */     
/* 181 */     this.lastGroupRowId = i;
/*     */     
/* 183 */     Aggregate aggregate = (Aggregate)hashMap.get(this);
/*     */     try {
/* 185 */       if (aggregate == null) {
/* 186 */         aggregate = getInstance();
/* 187 */         hashMap.put(this, aggregate);
/*     */       } 
/* 189 */       Object[] arrayOfObject = new Object[this.args.length];
/* 190 */       Object object = null; byte b; int j;
/* 191 */       for (b = 0, j = this.args.length; b < j; b++) {
/* 192 */         Value value = this.args[b].getValue(paramSession);
/* 193 */         value = value.convertTo(this.argTypes[b]);
/* 194 */         object = value.getObject();
/* 195 */         arrayOfObject[b] = object;
/*     */       } 
/* 197 */       if (this.args.length == 1) {
/* 198 */         aggregate.add(object);
/*     */       } else {
/* 200 */         aggregate.add(arrayOfObject);
/*     */       } 
/* 202 */     } catch (SQLException sQLException) {
/* 203 */       throw DbException.convert(sQLException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\JavaAggregate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */