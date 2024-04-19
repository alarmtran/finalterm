package Ex1;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * Kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        if(index >= limit){
            return false;
        }
        return true;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        bookList.add(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAPos(Book book, int index) {
        if(checkBoundaries(index,bookList.size())){
            bookList.add(index,book);
        }
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        if(checkBoundaries(index,bookList.size())){
            bookList.remove(index);
        }
    }

    /**
     * Bỏ book như tham số truyền vào.
     * @param book
     */
    public void remove(Book book) {
        boolean check = false;
        int index = 0;
        for(Book b : bookList){
            if(b.compareTo(book) == 0){
                check = true;
                break;
            }
            index++;
        }
        if(check){
            remove(index);
        }
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        if(checkBoundaries(index, bookList.size())){
            return bookList.get(index);
        }
        return null;
    }

    /**
     * Sắp xếp danh sách book theo thứ tự tăng dần theo title.
     * @return
     */
    public List<Book> sortIncreasingByTitle() {
        List<Book> cloneList = new ArrayList<>(bookList);
        for (int i = 0; i < cloneList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cloneList.size(); j++) {
                if (cloneList.get(j).getTitle().compareTo(cloneList.get(minIndex).getTitle()) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Book temp = cloneList.get(i);
                cloneList.set(i,cloneList.get(minIndex));
                cloneList.set(minIndex,temp);
            }
        }
        return cloneList;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo title tăng dần, nếu title như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortIncreasingTitleAndPrice() {
        List<Book> cloneList = new ArrayList<>(bookList);
        for (int i = 0; i < cloneList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cloneList.size(); j++) {
                Book current = cloneList.get(j);
                Book minBook = cloneList.get(minIndex);
                int titleCompareResult = current.getTitle().compareTo(minBook.getTitle());
                if (titleCompareResult < 0 || (titleCompareResult == 0 && current.getPrice() < minBook.getPrice())) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Book temp = cloneList.get(i);
                cloneList.set(i,cloneList.get(minIndex));
                cloneList.set(minIndex,temp);
            }
        }
        return cloneList;
    }


    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo title giảm dần, nếu title như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortDecreasingTitleAndPrice() {
        List<Book> cloneList = new ArrayList<>(bookList);
        for (int i = 0; i < cloneList.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < cloneList.size(); j++) {
                Book currentBook = cloneList.get(j);
                Book maxBook = cloneList.get(maxIndex);
                int titleCompareResult = currentBook.getTitle().compareTo(maxBook.getTitle());
                if (titleCompareResult > 0 || (titleCompareResult == 0 && currentBook.getPrice() > maxBook.getPrice())) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                Book temp = cloneList.get(i);
                cloneList.set(i,cloneList.get(maxIndex));
                cloneList.set(maxIndex,temp);
            }
        }
        return cloneList;
    }


    /**
     * Sắp xếp book theo giá tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        List<Book> cloneList = new ArrayList<>(bookList);
        for (int i = 0; i < cloneList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cloneList.size(); j++) {
                if (cloneList.get(j).getPrice() < cloneList.get(minIndex).getPrice()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Book temp = cloneList.get(i);
                cloneList.set(i, cloneList.get(minIndex));
                cloneList.set(minIndex, temp);
            }
        }
        return cloneList;
    }


    /**
     * Sắp xếp book theo giá giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        List<Book> cloneList = new ArrayList<>(bookList);
        for (int i = 0; i < cloneList.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < cloneList.size(); j++) {
                if (cloneList.get(j).getPrice() > cloneList.get(maxIndex).getPrice()) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                Book temp = cloneList.get(i);
                cloneList.set(i, cloneList.get(maxIndex));
                cloneList.set(maxIndex, temp);
            }
        }
        return cloneList;
    }

    /**
     * Sắp xếp book theo số trang tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPages() {
        List<Book> cloneList = new ArrayList<>(bookList);
        for (int i = 0; i < cloneList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < cloneList.size(); j++) {
                if (cloneList.get(j).getPages() < cloneList.get(minIndex).getPages()) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Book temp = cloneList.get(i);
                cloneList.set(i, cloneList.get(minIndex));
                cloneList.set(minIndex, temp);
            }
        }
        return cloneList;
    }


    /**
     * Sắp xếp book theo số trang giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPages() {
        List<Book> cloneList = new ArrayList<>(bookList);
        for (int i = 0; i < cloneList.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < cloneList.size(); j++) {
                if (cloneList.get(j).getPages() > cloneList.get(maxIndex).getPages()) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                Book temp = cloneList.get(i);
                cloneList.set(i, cloneList.get(maxIndex));
                cloneList.set(maxIndex, temp);
            }
        }
        return cloneList;
    }


    /**
     * Lọc ra howMany book có giá lớn nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterHighestPrice(int howMany) {
        sortDecreasingPrice();
        double maxPrice = bookList.get(0).getPrice();
        ArrayList<Book> listBookNew = new ArrayList<>();
        int count = 0;
        for(Book b : bookList){
            if(b.getPrice() == maxPrice){
                listBookNew.add(b);
                count++;
            }
            if(count == howMany){
                break;
            }
        }
        return listBookNew;
    }

    /**
     * Lọc ra những book có giá cao hơn lowerBound.
     * @param lowerBound
     * @return
     */
    public List<Book> filterBooksPriceHigherThan(double lowerBound) {
        ArrayList<Book> listBookNew = new ArrayList<>();
        for(Book b : bookList){
            if(b.getPrice() > lowerBound){
                listBookNew.add(b);
            }
        }
        return listBookNew;
    }

    /**
     * Lọc ra howMany book có số trang nhỏ nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterBookLowestPages(int howMany) {
        sortIncreasingPages();
        int minPages = bookList.get(0).getPages();
        ArrayList<Book> listBookNew = new ArrayList<>();
        int count = 0;
        for(Book b : bookList){
            if(b.getPages() == minPages){
                listBookNew.add(b);
                count++;
            }
            if(count == howMany){
                break;
            }
        }
        return listBookNew;
    }

    /**
     * Lọc ra howMany book có số trang nhỏ hơn upperBound.
     * @param upperBound
     * @return
     */
    public List<Book> filterBooksPagesLowerThan(double upperBound) {
        ArrayList<Book> listBookNew = new ArrayList<>();
        for(Book b : bookList){
            if(b.getPages() < upperBound){
                listBookNew.add(b);
            }
        }
        return listBookNew;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        ArrayList<Book> listBookNew = new ArrayList<>();
        for(Book b : bookList){
            if(b.getPublisher().compareTo(publisher) == 0){
                listBookNew.add(b);
            }
        }
        return listBookNew;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        ArrayList<Book> listBookNew = new ArrayList<>();
        for(Book b : bookList){
            if(b.getGenre().compareTo(genre) == 0){
                listBookNew.add(b);
            }
        }
        return listBookNew;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        ArrayList<Book> listBookNew = new ArrayList<>();
        for(Book b : bookList){
            if(b.getAuthor().compareTo(author) == 0){
                listBookNew.add(b);
            }
        }
        return listBookNew;
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
