public class employee implements table{
    @Override
    public  updateTable(INT empid){
        return ;
    }

    @Override
    public String addColumn(String column){
        return  "ALTER TABLE employee ADD '" + column + "'INT;";
    }

    @Override
    public  searchTable();{
        return
    }
}
