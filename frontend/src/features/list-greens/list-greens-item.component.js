import React from 'react';
import PropTypes from 'prop-types';
import classNames from 'classnames';
import { MONTHS, COMPANION_TYPE } from 'services/constants';
import { getCompanionType } from 'services';
import './list-greens.scss';


const getMonthName = (period) => (Object.values(MONTHS).find(m => m.key === period).initial);

function CompanionTypeButtons({ disableButtons, onBadClick, onGoodClick, companionType }) {
  const baseClasses = 'btn btn-sm ListGreensItem_typeButton';

  const handleToggleGoodCompanion = () => onGoodClick(COMPANION_TYPE.good);
  const handleToggleBadCompanion = () => onBadClick(COMPANION_TYPE.bad);

  const isGoodCompanion =  (companionType) => companionType === COMPANION_TYPE.good;
  const isBadCompanion = (companionType) => companionType === COMPANION_TYPE.bad;

  return (
    <React.Fragment>
      <button
        className={classNames(baseClasses, 'btn-outline-success', {'ListGreensItem_typeButton-goodSelected': isGoodCompanion(companionType)})}
        onClick={handleToggleGoodCompanion}
        disabled={disableButtons}
      >good</button>
    <button
        className={classNames(baseClasses, 'btn-outline-danger', {'ListGreensItem_typeButton-badSelected': isBadCompanion(companionType)})}
        onClick={handleToggleBadCompanion}
        disabled={disableButtons}
      >bad</button>
    </React.Fragment>
  )
}

CompanionTypeButtons.propTypes = {
  disableButtons: PropTypes.bool.isRequired,
  onBadClick: PropTypes.func.isRequired,
  onGoodClick: PropTypes.func.isRequired,
  companionType: PropTypes.number.isRequired
};


export const ListGreensItem = ({ green, selectedGreen, onSelectClick, onCompanionClick }) => {
  const noneSelected = Object.keys(selectedGreen).length === 0;
  const isSelected = selectedGreen.id === green.id;
  // Disable the buttons if no green is selected on the list or, if there is one,
  // this item is the selected green.
  const disableCompanionTypeButtons = isSelected || noneSelected;
  const companionType = getCompanionType(green, selectedGreen);

  const handleSelect = () => {
    if(disableCompanionTypeButtons) {
      onSelectClick(green)
    }
  };

  const handleCompanionToggle = (type) => onCompanionClick(green, type);

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
        {green.sowPeriod.map(period =>
          <span key={period} className="ListGreens_monthInitials">{getMonthName(period)}</span>)}
      </td>
      <td className="ListGreens_cell">
        {green.growPeriod.map(period =>
          <span key={period} className="ListGreens_monthInitials">{getMonthName(period)}</span>)}
      </td>
      <td className="ListGreens_cell">
        {green.harvestPeriod.map(period =>
          <span key={period} className="ListGreens_monthInitials">{getMonthName(period)}</span>)}
      </td>
      <td className="ListGreens_cell">
        <CompanionTypeButtons
          disableButtons={disableCompanionTypeButtons}
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
