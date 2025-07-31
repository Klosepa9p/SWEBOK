
//Before refactoring

double PotentialEnergy(double mass, double height) 
{
  return mass * height * 9.81;
}


//Replace magic number with symbolic constant

const double GRAVITATIONAL_CONSTANT = 9.81;

double PotentialEnergy(double mass, double height) 
{
  return mass * height * GRAVITATIONAL_CONSTANT;
}

