package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException
    {
        String path = ".\\testData\\Opencart_LoginDatas.xlsx";

        ExcelUtility xlutil = new ExcelUtility(path);

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        String logindata[][] = new String[totalrows][totalcols];

        for (int i = 1; i <= totalrows; i++)
        {
            // ✅ Skip null or empty rows (prevents NullPointerException)
            if (xlutil.sheet == null || xlutil.sheet.getRow(i) == null) {
                continue;
            }

            for (int j = 0; j < totalcols; j++)
            {
                try {
                    logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
                } catch (Exception e) {
                    logindata[i - 1][j] = "";   // fallback for empty cells
                }
            }
        }

        return logindata;
    }
}
