
HashMap<String,Boolean>city=new HashMap<>();
		
for(String src:map.keySet())
{
    String dest=map.get(src);
    city.put(dest,false);
    
    if(city.containsKey(src)==false)
    {
        city.put(src,true);
    }
}
String startingPoint="";
for(String src:city.keySet())
{
    if(city.get(src)==true)
    {
        startingPoint=src;
        break;
    }
}

while(true)
{
    if(map.containsKey(startingPoint))
    {
        System.out.print(startingPoint+" -> ");
        startingPoint=map.get(startingPoint);
    }
    else
    {
        System.out.print(startingPoint+".");
        break;
    }
}

}