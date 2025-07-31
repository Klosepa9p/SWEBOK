

//Before Refactoring

class Range 
{
  private int low, high;
  
  bool Includes(int arg) 
  {
    return arg >= low && arg <= high;
  }
}


//Self Encapsulate Field Refactoring

class Range 
{
  private int low, high;
  
  int Low {
    get { return low; }
  }
  int High {
    get { return high; }
  }
  
  bool Includes(int arg) 
  {
    return arg >= Low && arg <= High;
  }
}

