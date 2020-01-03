import React from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';
import { MONTHS, COMPANION_TYPE } from 'services/constants';
import { getCompanionType } from 'services';
import './list-greens.scss';


const getMonthName = (period) => (Object.values(MONTHS).find(m => m.key === period).name);

function CompanionTypeButtons({ showCompanionTypeButtons, onBadClick, onGoodClick, companionType }) {
  const handleToggleGoodCompanion = (event) => {
    event.preventDefault();
    onGoodClick(COMPANION_TYPE.good);
  };

  const handleToggleBadCompanion = (event) => {
    event.preventDefault();
    onBadClick(COMPANION_TYPE.bad);
  }

  if (showCompanionTypeButtons) {
    const baseClasses = 'btn btn-sm ListGreensItem_typeButton';
    return (
      <React.Fragment>
        <div
          className={classNames(baseClasses, 'btn-outline-success', {'ListGreensItem_typeButton-goodSelected': companionType === COMPANION_TYPE.good})}
          onClick={handleToggleGoodCompanion}
          disabled={companionType === COMPANION_TYPE.bad}
        >good</div>
        <div
          className={classNames(baseClasses, 'btn-outline-danger', {'ListGreensItem_typeButton-badSelected': companionType === COMPANION_TYPE.bad})}
          onClick={handleToggleBadCompanion}
          disabled={companionType === COMPANION_TYPE.good}
        >bad</div>
      </React.Fragment>
    )
  }
  return null;
}

CompanionTypeButtons.propTypes = {
  showCompanionTypeButtons: PropTypes.bool.isRequired,
  onBadClick: PropTypes.func.isRequired,
  onGoodClick: PropTypes.func.isRequired,
  companionType: PropTypes.number.isRequired
};


export const ListGreensItem = ({ green, selectedGreen, onSelectClick, onCompanionClick }) => {
  const hasSelected = Object.keys(selectedGreen).length > 0;
  const isSelected = selectedGreen.id === green.id;
  let showCompanionTypeButtons = false;
  let companionType;
  if (hasSelected) {
    showCompanionTypeButtons = !isSelected;
    companionType = getCompanionType(green, selectedGreen);
  }

  const handleSelect = () => {
    if(!showCompanionTypeButtons) {
      onSelectClick(green)
    }
  };

  const handleCompanionToggle = (toggledCompanionType) => onCompanionClick(green, toggledCompanionType);

  return (
    <tr
      id={green.id}
      key={green.id}
      className={classNames('ListGreens_row', { 'ListGreens_row-selected': isSelected })}
      onClick={handleSelect}
    >
      <td className="ListGreens_cell">
        {green.name}
      </td>
      <td className="ListGreens_cell">
        {green.description}
      </td>
      <td className="ListGreens_cell">
        {green.sowPeriod.map(period => <span key={period}>{getMonthName(period)}</span>)}
      </td>
      <td className="ListGreens_cell">
        {green.growPeriod.map(period => <span key={period}>{getMonthName(period)}</span>)}
      </td>
      <td className="ListGreens_cell">
        {green.harvestPeriod.map(period => <span key={period}>{getMonthName(period)}</span>)}
      </td>
      <td className="ListGreens_cell">
        <CompanionTypeButtons
          showCompanionTypeButtons={showCompanionTypeButtons}
          onBadClick={handleCompanionToggle}
          onGoodClick={handleCompanionToggle}
          companionType={companionType}
        />
      </td>
    </tr>
  )
}

ListGreensItem.propTypes = {
  green: PropTypes.object.isRequired,
  selectedGreen: PropTypes.object.isRequired,
  onSelectClick: PropTypes.func.isRequired,
  onCompanionClick: PropTypes.func.isRequired,
};
