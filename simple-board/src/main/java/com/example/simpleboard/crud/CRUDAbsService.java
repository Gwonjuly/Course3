package com.example.simpleboard.crud;

import com.example.simpleboard.common.Api;
import com.example.simpleboard.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * dto -> Entity -> dto
 * DTO create()
 3. save -> dto
 */
public abstract class CRUDAbsService<DTO, ENTITY> implements CRUDinterface<DTO>{

    //추상 클래스? 인터페이스는 빈으로 등록될 수 없음-> 하기와 같이 작성
    @Autowired(required = false)//컨버터를 상솏받은 빈이 있다면 값이 채워짐, 없을 경우에는 null
    private Converter<DTO,ENTITY> converter;

    @Autowired(required = false)
    private JpaRepository<ENTITY,Long> jpaRepository;//entity(board, post)에 맞는 jparepostory를 찾아서 스플링 주입

    @Override
    public DTO create(DTO dto) {
        //dto -> entity
        var entity=converter.toEntity(dto);

        //entity -> save
        jpaRepository.save(entity);

        //save -> dto
        var returDto=converter.toDto(entity);
        return returDto;
    }

    @Override
    public Optional<DTO> read(Long id) {
        var optionalEntity=jpaRepository.findById(id);
        var dto=optionalEntity.map(
                it->{
                    return converter.toDto(it);
                }
        ).orElseGet(()->null);
        return Optional.ofNullable(dto);
    }

    @Override
    public DTO update(DTO dto) {
        var entity=converter.toEntity(dto);
        jpaRepository.save(entity);
        return converter.toDto(entity);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Api<List<DTO>> list(Pageable pageable) {
        var list=jpaRepository.findAll(pageable);
        var pagination= Pagination.builder()
                .currentElements(list.getNumberOfElements())
                .size(list.getSize())
                .totalElements(list.getTotalElements())
                .totalPage(list.getTotalPages())
                .page(list.getNumber())
                .build();
        var dtoList=list.stream()
                .map(it->{
                    return converter.toDto(it);
                })
                .collect(Collectors.toList());
        var res=Api.<List<DTO>>builder()
                .body(dtoList)
                .pagination(pagination)
                .build();
        return res;
    }
}
