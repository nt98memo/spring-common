package com.example.common.service.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.common.dao.demo.SampleDao;
import com.example.common.dto.demo.SampleForListDto;
import com.example.common.entity.demo.Sample;
import com.example.common.repository.demo.SampleRepository;
import com.example.common.search.demo.SampleSearch;
import com.example.common.service.BaseService;
import com.example.common.util.PropUtil;

@Service
public class SampleService extends BaseService<Sample, SampleSearch, SampleRepository, SampleDao> {

    public Page<Sample> getPage(Pageable pageable) {
    	Page<Sample> list = this.repository.findAll(pageable);
        return list;
    }

    public List<SampleForListDto> getList() {
    	List<SampleForListDto> list = this.repository.getList();
        return list;
    }

    public SampleForListDto getDto(long id) {
    	SampleForListDto dto = this.repository.getDto(id);
        return dto;
    }

    public Sample findById(Long id) {
    	Sample entity = this.repository.findById(id).orElse(null);
        return entity;
    }

    public Sample findByIdForUpdate(Long id) {
    	Sample entity = this.repository.findByIdForUpdate(id);
        return entity;
    }

    @Override
    public void insert(Sample entity) {
    	this.repository.saveAndFlush(entity);
    }

	@Override
	public void update(Sample entity) {
		Sample record = this.findById(entity.getId());
		PropUtil.copyProperties(entity, record, new String[]{"intCol","longCol","decimalCol","textCol","passwordCol","textareaCol","radioCol","selectCol","dateCol","timeCol","datetimeCol","updateSystem","updateUserId","updateUrl"});
    	this.repository.saveAndFlush(record);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public List<Sample> find(SampleSearch entity) {
    	return this.repository.findAll();
	}

	public List<SampleForListDto> getSampleList() {
		return this.dao.getSampleList();
	}

	public Page<Sample> searchSample(SampleSearch searchEntity) {
		return this.dao.searchSample(searchEntity);
	}
	
}
