

//Before refactoring

string[] row = new string[2];
row[0] = "Liverpool";
row[1] = "15";


//Replace Data Value with Object 

Performance row = new Performance();
row.SetName("Liverpool");
row.SetWins("15");

