package DataService;

/**
* DataService/_operatorHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从DataService.idl
* 2020年5月2日 星期六 下午03时24分37秒 CST
*/

public final class _operatorHolder implements org.omg.CORBA.portable.Streamable
{
  public DataService._operator value = null;

  public _operatorHolder ()
  {
  }

  public _operatorHolder (DataService._operator initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DataService._operatorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DataService._operatorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DataService._operatorHelper.type ();
  }

}
