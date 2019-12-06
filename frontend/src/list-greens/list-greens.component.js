import React from 'react';
import './list-greens.scss';
import { ListGreensItem } from './list-greens-item.component';

export const ListGreens = ({ greens=[], selectedGreen, onClick }) =>
  (
    <table className="table table-striped table-hover ListGreens_table">
      <thead className="thead-dark ListGreens_row">
        <tr>
          <th className="ListGreens_cell" scope="col">
            Name
          </th>
          <th className="ListGreens_cell" scope="col">
            Description
          </th>
          <th className="ListGreens_cell" scope="col">
            Sow Period
          </th>
          <th className="ListGreens_cell" scope="col">
            Grow Period
          </th>
          <th className="ListGreens_cell" scope="col">
            Harvest Period
          </th>
        </tr>
      </thead>
      <tbody>
      {
        greens.map(green => {
          const isSelected = selectedGreen && selectedGreen.id === green.id;
          return <ListGreensItem key={green.id} green={green} onClick={onClick} isSelected={isSelected} />
        })
      }
      </tbody>
    </table>
  );
