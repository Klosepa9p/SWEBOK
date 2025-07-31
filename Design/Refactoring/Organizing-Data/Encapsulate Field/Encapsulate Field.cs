
//Before Refactoring

class Person 
{
  public string name;
}



//Encapsulated Field

class Person 
{
  private string name;

  public string Name
  {
    get { return name; }
    set { name = value; }
  }
}

