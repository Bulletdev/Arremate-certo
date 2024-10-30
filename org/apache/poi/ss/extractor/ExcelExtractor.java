package org.apache.poi.ss.extractor;

public interface ExcelExtractor {
  void setIncludeSheetNames(boolean paramBoolean);
  
  void setFormulasNotResults(boolean paramBoolean);
  
  void setIncludeHeadersFooters(boolean paramBoolean);
  
  void setIncludeCellComments(boolean paramBoolean);
  
  String getText();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\extractor\ExcelExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */