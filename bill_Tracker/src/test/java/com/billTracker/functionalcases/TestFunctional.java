/*
 * package com.billTracker.functionalcases;
 * 
 * import static org.mockito.Mockito.when;
 * 
 * import static org.mockito.BDDMockito.then; import static
 * org.mockito.Mockito.when;
 * 
 * import java.io.File; import java.io.IOException; import java.util.ArrayList;
 * import java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.apache.commons.io.FileUtils; import org.junit.Before; import
 * org.junit.Test; import org.mockito.InjectMocks; import org.mockito.Mock;
 * import org.mockito.MockitoAnnotations; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import com.billTracker.dao.BillDao; import com.billTracker.dao.BillDaoImpl;
 * import com.billTracker.model.Billes; import
 * com.billTracker.service.BillServiceImpl; import
 * com.billTracker.utiltestclass.MasterData;
 * 
 * @RunWith(MockitoJUnitRunner.class) public class TestFunctional {
 * 
 * @Mock private BillDaoImpl billDao;
 * 
 * @InjectMocks private BillServiceImpl billServiceImpl;
 * 
 * static { System.out.println("static  line"); File file = new
 * File("output_revised.txt"); if (file.exists()) { try {
 * FileUtils.forceDelete(new File("output_revised.txt")); } catch (IOException
 * e) {
 * 
 * } } }
 * 
 * @Before public void init() { System.out.println("first line");
 * MockitoAnnotations.initMocks(this); System.out.println("Lsast line"); }
 * 
 * @Test public void BillViewlAll() throws Exception {
 * 
 * List<Billes> list = new ArrayList<>(); List<Billes> noteList; list.add(new
 * Billes()); list.add(new Billes());
 * 
 * when(billServiceImpl.getAllBillInfo()).thenReturn((List<Billes>) list);
 * noteList = billServiceImpl.getAllBillInfo(); File file = new
 * File("output_revised.txt"); FileUtils.write(file, "\n testViewAll = " +
 * (noteList.size() == 2 ? true : false), true); }
 * 
 * @Test public void DeleteBill() throws IOException { Boolean flag = true;
 * when(billServiceImpl.deleteBill((long) 10008)).thenReturn(flag); boolean
 * stats = billServiceImpl.deleteBill((long) 10008); File file = new
 * File("output_revised.txt"); FileUtils.write(file, "\n DeleteBill = " + (stats
 * ? true : false), true);
 * 
 * }
 * 
 * }
 */