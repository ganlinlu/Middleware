package DataService;


/**
* DataService/_operator.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从DataService.idl
* 2020年5月2日 星期六 下午03时24分37秒 CST
*/

public final class _operator implements org.omg.CORBA.portable.IDLEntity
{
  public String ID = null;
  public String StudentNumber = null;
  public String Classes = null;
  public String score = null;
  public boolean isInsert = false;

  public _operator ()
  {
  } // ctor

  public _operator (String _ID, String _StudentNumber, String _Classes, String _score, boolean _isInsert)
  {
    ID = _ID;
    StudentNumber = _StudentNumber;
    Classes = _Classes;
    score = _score;
    isInsert = _isInsert;
  } // ctor

} // class _operator
