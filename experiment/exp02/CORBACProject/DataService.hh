// This file is generated by omniidl (C++ backend)- omniORB_4_2. Do not edit.
#ifndef __DataService_hh__
#define __DataService_hh__

#ifndef __CORBA_H_EXTERNAL_GUARD__
#include <omniORB4/CORBA.h>
#endif

#ifndef  USE_stub_in_nt_dll
# define USE_stub_in_nt_dll_NOT_DEFINED_DataService
#endif
#ifndef  USE_core_stub_in_nt_dll
# define USE_core_stub_in_nt_dll_NOT_DEFINED_DataService
#endif
#ifndef  USE_dyn_stub_in_nt_dll
# define USE_dyn_stub_in_nt_dll_NOT_DEFINED_DataService
#endif






#ifdef USE_stub_in_nt_dll
# ifndef USE_core_stub_in_nt_dll
#  define USE_core_stub_in_nt_dll
# endif
# ifndef USE_dyn_stub_in_nt_dll
#  define USE_dyn_stub_in_nt_dll
# endif
#endif

#ifdef _core_attr
# error "A local CPP macro _core_attr has already been defined."
#else
# ifdef  USE_core_stub_in_nt_dll
#  define _core_attr _OMNIORB_NTDLL_IMPORT
# else
#  define _core_attr
# endif
#endif

#ifdef _dyn_attr
# error "A local CPP macro _dyn_attr has already been defined."
#else
# ifdef  USE_dyn_stub_in_nt_dll
#  define _dyn_attr _OMNIORB_NTDLL_IMPORT
# else
#  define _dyn_attr
# endif
#endif



_CORBA_MODULE DataService

_CORBA_MODULE_BEG

  struct _cxx_operator {
    typedef _CORBA_ConstrType_Variable_Var<_cxx_operator> _var_type;

    
    ::CORBA::String_member ID;

    ::CORBA::String_member StudentNumber;

    ::CORBA::String_member Classes;

    ::CORBA::String_member score;

    ::CORBA::Boolean isInsert;

  

    void operator>>= (cdrStream &) const;
    void operator<<= (cdrStream &);
  };

  typedef _cxx_operator::_var_type _cxx_operator_var;

  typedef _CORBA_ConstrType_Variable_OUT_arg< _cxx_operator,_cxx_operator_var > _cxx_operator_out;

#ifndef __DataService_mDataTransform__
#define __DataService_mDataTransform__
  class DataTransform;
  class _objref_DataTransform;
  class _impl_DataTransform;
  
  typedef _objref_DataTransform* DataTransform_ptr;
  typedef DataTransform_ptr DataTransformRef;

  class DataTransform_Helper {
  public:
    typedef DataTransform_ptr _ptr_type;

    static _ptr_type _nil();
    static _CORBA_Boolean is_nil(_ptr_type);
    static void release(_ptr_type);
    static void duplicate(_ptr_type);
    static void marshalObjRef(_ptr_type, cdrStream&);
    static _ptr_type unmarshalObjRef(cdrStream&);
  };

  typedef _CORBA_ObjRef_Var<_objref_DataTransform, DataTransform_Helper> DataTransform_var;
  typedef _CORBA_ObjRef_OUT_arg<_objref_DataTransform,DataTransform_Helper > DataTransform_out;

#endif

  // interface DataTransform
  class DataTransform {
  public:
    // Declarations for this interface type.
    typedef DataTransform_ptr _ptr_type;
    typedef DataTransform_var _var_type;

    static _ptr_type _duplicate(_ptr_type);
    static _ptr_type _narrow(::CORBA::Object_ptr);
    static _ptr_type _unchecked_narrow(::CORBA::Object_ptr);
    
    static _ptr_type _nil();

    static inline void _marshalObjRef(_ptr_type, cdrStream&);

    static inline _ptr_type _unmarshalObjRef(cdrStream& s) {
      omniObjRef* o = omniObjRef::_unMarshal(_PD_repoId,s);
      if (o)
        return (_ptr_type) o->_ptrToObjRef(_PD_repoId);
      else
        return _nil();
    }

    static inline _ptr_type _fromObjRef(omniObjRef* o) {
      if (o)
        return (_ptr_type) o->_ptrToObjRef(_PD_repoId);
      else
        return _nil();
    }

    static _core_attr const char* _PD_repoId;

    // Other IDL defined within this scope.
    
  };

  class _objref_DataTransform :
    public virtual ::CORBA::Object,
    public virtual omniObjRef
  {
  public:
    // IDL operations
    char* sendData(const ::DataService::_cxx_operator& name);

    // Constructors
    inline _objref_DataTransform()  { _PR_setobj(0); }  // nil
    _objref_DataTransform(omniIOR*, omniIdentity*);

  protected:
    virtual ~_objref_DataTransform();

    
  private:
    virtual void* _ptrToObjRef(const char*);

    _objref_DataTransform(const _objref_DataTransform&);
    _objref_DataTransform& operator = (const _objref_DataTransform&);
    // not implemented

    friend class DataTransform;
  };

  class _pof_DataTransform : public _OMNI_NS(proxyObjectFactory) {
  public:
    inline _pof_DataTransform() : _OMNI_NS(proxyObjectFactory)(DataTransform::_PD_repoId) {}
    virtual ~_pof_DataTransform();

    virtual omniObjRef* newObjRef(omniIOR*,omniIdentity*);
    virtual _CORBA_Boolean is_a(const char*) const;
  };

  class _impl_DataTransform :
    public virtual omniServant
  {
  public:
    virtual ~_impl_DataTransform();

    virtual char* sendData(const ::DataService::_cxx_operator& name) = 0;
    
  public:  // Really protected, workaround for xlC
    virtual _CORBA_Boolean _dispatch(omniCallHandle&);

  private:
    virtual void* _ptrToInterface(const char*);
    virtual const char* _mostDerivedRepoId();
    
  };


_CORBA_MODULE_END



_CORBA_MODULE POA_DataService
_CORBA_MODULE_BEG

  class DataTransform :
    public virtual DataService::_impl_DataTransform,
    public virtual ::PortableServer::ServantBase
  {
  public:
    virtual ~DataTransform();

    inline ::DataService::DataTransform_ptr _this() {
      return (::DataService::DataTransform_ptr) _do_this(::DataService::DataTransform::_PD_repoId);
    }
  };

_CORBA_MODULE_END



_CORBA_MODULE OBV_DataService
_CORBA_MODULE_BEG

_CORBA_MODULE_END





#undef _core_attr
#undef _dyn_attr



inline void
DataService::DataTransform::_marshalObjRef(::DataService::DataTransform_ptr obj, cdrStream& s) {
  omniObjRef::_marshal(obj->_PR_getobj(),s);
}



#ifdef   USE_stub_in_nt_dll_NOT_DEFINED_DataService
# undef  USE_stub_in_nt_dll
# undef  USE_stub_in_nt_dll_NOT_DEFINED_DataService
#endif
#ifdef   USE_core_stub_in_nt_dll_NOT_DEFINED_DataService
# undef  USE_core_stub_in_nt_dll
# undef  USE_core_stub_in_nt_dll_NOT_DEFINED_DataService
#endif
#ifdef   USE_dyn_stub_in_nt_dll_NOT_DEFINED_DataService
# undef  USE_dyn_stub_in_nt_dll
# undef  USE_dyn_stub_in_nt_dll_NOT_DEFINED_DataService
#endif

#endif  // __DataService_hh__

