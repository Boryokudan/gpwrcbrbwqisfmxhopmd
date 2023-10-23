package greetgo.kz.gpwrcbrbwqisfmxhopmd.common;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class FilteredPage implements Pageable {

    private Filter filter;

    private Sort sort;

    public FilteredPage(Filter filter, Sort sort) {
        if (filter.getLimit() < 1) {
            throw new IllegalArgumentException("Limit must not be less than one!");
        }
        if (filter.getOffset() < 0) {
            throw new IllegalArgumentException("Offset index must not be less than zero!");
        }
        this.filter = filter;
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return filter.getOffset() / filter.getLimit();
    }

    @Override
    public int getPageSize() {
        return filter.getLimit();
    }

    @Override
    public long getOffset() {
        return filter.getOffset();
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    @Override
    public Pageable next() {
        return new FilteredPage(new Filter(filter.getLimit(), filter.getOffset() + filter.getLimit()), sort);
    }

    public Pageable previous() {
        return hasPrevious() ?
                new FilteredPage(new Filter(filter.getLimit(), filter.getOffset() - filter.getLimit()), sort): this;
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public Pageable first() {
        return new FilteredPage(new Filter(filter.getLimit(), 0), sort);
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return filter.getOffset() > filter.getLimit();
    }
}